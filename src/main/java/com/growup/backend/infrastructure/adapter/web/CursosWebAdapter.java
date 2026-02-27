package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.CursosApiDelegate;
import com.growup.backend.domain.port.in.CourseInPort;
import com.growup.backend.domain.port.in.UserInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.CourseWebMapper;
import com.growup.backend.model.Course;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.Syllabus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador Web para Cursos.
 * Implementa CursosApiDelegate delegando en el puerto de entrada CourseInPort.
 */
@Slf4j
@Component
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
public class CursosWebAdapter implements CursosApiDelegate {

    private final CourseInPort courseInPort;
    private final UserInPort userInPort;
    private final CourseWebMapper courseMapper;

    @Override
    public ResponseEntity<List<Course>> coursesGet(String category, CourseLevel level, CourseStatus status) {
        log.info("GrowUp-Log: CursosWebAdapter - Buscando cursos con filtros - Categoria: {}, Nivel: {}, Estado: {}",
                category, level, status);
        log.info("GrowUp-Log: CursosWebAdapter - Buscando cursos con filtros - Estado: {}", status.getValue());
        var domainCourses = courseInPort.getAllCourses(
                category,
                level != null ? level.getValue() : null,
                status != null ? status.getValue() : null);
        return ResponseEntity.ok(domainCourses.stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Course> coursesIdGet(UUID id) {
        var domainCourse = courseInPort.getCourseById(id);
        return ResponseEntity.ok(courseMapper.toDto(domainCourse));
    }

    @Override
    public ResponseEntity<Course> coursesPost(Course courseDto) {
        // Spring Security ya ha extraído el email del token en el
        // JwtAuthenticationFilter
        String currentEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        var instructor = userInPort.getUserByEmail(currentEmail);
        log.info("GrowUp-Log: CursosWebAdapter - Instructor: {}", instructor);

        var domainCourse = courseMapper.toDomain(courseDto);
        var created = courseInPort.createCourse(domainCourse, instructor.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(courseMapper.toDto(created));
    }

    @Override
    public ResponseEntity<Course> coursesIdPut(UUID id, Course courseDto) {
        // log.info("Updating course with ID: {}", id);
        // log.info("Course DTO: {}", courseDto);
        var domainCourse = courseMapper.toDomain(courseDto);
        var updated = courseInPort.updateCourse(id, domainCourse);
        return ResponseEntity.ok(courseMapper.toDto(updated));
    }

    @Override
    public ResponseEntity<Void> coursesIdDelete(UUID id) {
        courseInPort.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Syllabus>> coursesIdSyllabusGet(UUID id) {
        // En este modelo, el syllabus es parte del curso.
        var domainCourse = courseInPort.getCourseById(id);
        var courseDto = courseMapper.toDto(domainCourse);
        return ResponseEntity.ok(courseDto.getSyllabus());
    }
}
