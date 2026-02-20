package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.api.CursosApiDelegate;
import com.growup.backend.domain.port.in.CourseInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.CourseWebMapper;
import com.growup.backend.model.Course;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.Syllabus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Adaptador Web para Cursos.
 * Implementa CursosApiDelegate delegando en el puerto de entrada CourseInPort.
 */
@Component
@RequiredArgsConstructor
public class CursosWebAdapter implements CursosApiDelegate {

    private final CourseInPort courseInPort;
    private final CourseWebMapper courseMapper;

    // TODO: Obtener del SecurityContext en producción
    private static final UUID MOCK_INSTRUCTOR_ID = UUID.fromString("00000000-0000-0000-0000-000000000002");

    @Override
    public ResponseEntity<List<Course>> coursesGet(String category, CourseLevel level, CourseStatus status) {
        var domainCourses = courseInPort.getAllCourses(
                category,
                level != null ? level.toString() : null,
                status != null ? status.toString() : null);
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
        var domainCourse = courseMapper.toDomain(courseDto);
        var created = courseInPort.createCourse(domainCourse, MOCK_INSTRUCTOR_ID);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseMapper.toDto(created));
    }

    @Override
    public ResponseEntity<Course> coursesIdPut(UUID id, Course courseDto) {
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
