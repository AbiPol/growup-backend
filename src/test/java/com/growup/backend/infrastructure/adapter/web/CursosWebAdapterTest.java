package com.growup.backend.infrastructure.adapter.web;

import com.growup.backend.domain.port.in.CourseInPort;
import com.growup.backend.domain.port.in.UserInPort;
import com.growup.backend.infrastructure.adapter.web.mapper.CourseWebMapper;
import com.growup.backend.model.Course;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.Syllabus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para CursosWebAdapter.
 * Verifica la delegación a los puertos de entrada y el mapeo de DTOs.
 */
@ExtendWith(MockitoExtension.class)
class CursosWebAdapterTest {

    @Mock
    private CourseInPort courseInPort;

    @Mock
    private UserInPort userInPort;

    @Mock
    private CourseWebMapper courseMapper;

    @InjectMocks
    private CursosWebAdapter cursosWebAdapter;

    private UUID courseId;
    private Course courseDto;
    private com.growup.backend.domain.model.Course courseDomain;

    @BeforeEach
    void setUp() {
        courseId = UUID.randomUUID();

        courseDto = new Course();
        courseDto.setId(courseId);
        courseDto.setName("Curso de Prueba");

        courseDomain = new com.growup.backend.domain.model.Course();
        courseDomain.setId(courseId);
        courseDomain.setName("Curso de Prueba");
    }

    @Nested
    @DisplayName("Pruebas para coursesGet")
    class CoursesGetTests {
        @Test
        @DisplayName("Debería listar cursos aplicando filtros y mapeando a DTO")
        void shouldReturnListWithFilters() {
            // Mock de Seguridad
            String currentEmail = "instructor@test.com";
            Authentication authentication = mock(Authentication.class);
            when(authentication.getName()).thenReturn(currentEmail);
            SecurityContext securityContext = mock(SecurityContext.class);
            when(securityContext.getAuthentication()).thenReturn(authentication);
            SecurityContextHolder.setContext(securityContext);

            // Datos del instructor
            UUID instructorId = UUID.randomUUID();
            com.growup.backend.domain.model.User instructor = new com.growup.backend.domain.model.User();
            instructor.setId(instructorId);

            // Configuración
            when(userInPort.getUserByEmail(currentEmail)).thenReturn(instructor);
            when(courseInPort.getAllCourses(instructorId, "Tecnología", "Principiante", "Publicado"))
                    .thenReturn(Arrays.asList(courseDomain));
            when(courseMapper.toDto(courseDomain)).thenReturn(courseDto);

            // Ejecución
            ResponseEntity<List<Course>> response = cursosWebAdapter.coursesGet(
                    "Tecnología", CourseLevel.PRINCIPIANTE, CourseStatus.PUBLICADO);

            // Verificación
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().size());
            verify(courseInPort).getAllCourses(instructorId, "Tecnología", "Principiante", "Publicado");

            // Limpieza
            SecurityContextHolder.clearContext();
        }
    }

    @Nested
    @DisplayName("Pruebas para coursesIdGet")
    class CoursesIdGetTests {
        @Test
        @DisplayName("Debería obtener un curso por su ID")
        void shouldGetCourseById() {
            // Configuración
            when(courseInPort.getCourseById(courseId)).thenReturn(courseDomain);
            when(courseMapper.toDto(courseDomain)).thenReturn(courseDto);

            // Ejecución
            ResponseEntity<Course> response = cursosWebAdapter.coursesIdGet(courseId);

            // Verificación
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(courseDto, response.getBody());
        }
    }

    @Nested
    @DisplayName("Pruebas para coursesPost")
    class CoursesPostTests {
        @Test
        @DisplayName("Debería crear un curso recuperando el instructor desde el contexto de seguridad")
        void shouldPostCourseSuccessfully() {
            // Mock de Seguridad
            String currentEmail = "instructor@test.com";
            Authentication authentication = mock(Authentication.class);
            when(authentication.getName()).thenReturn(currentEmail);
            SecurityContext securityContext = mock(SecurityContext.class);
            when(securityContext.getAuthentication()).thenReturn(authentication);
            SecurityContextHolder.setContext(securityContext);

            // Datos del instructor
            UUID instructorId = UUID.randomUUID();
            com.growup.backend.domain.model.User instructor = new com.growup.backend.domain.model.User();
            instructor.setId(instructorId);

            // Configuración de mocks
            when(userInPort.getUserByEmail(currentEmail)).thenReturn(instructor);
            when(courseMapper.toDomain(courseDto)).thenReturn(courseDomain);
            when(courseInPort.createCourse(courseDomain, instructorId)).thenReturn(courseDomain);
            when(courseMapper.toDto(courseDomain)).thenReturn(courseDto);

            // Ejecución
            ResponseEntity<Course> response = cursosWebAdapter.coursesPost(courseDto);

            // Verificación
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            verify(courseInPort).createCourse(courseDomain, instructorId);

            // Limpieza
            SecurityContextHolder.clearContext();
        }
    }

    @Nested
    @DisplayName("Pruebas para coursesIdPut")
    class CoursesIdPutTests {
        @Test
        @DisplayName("Debería actualizar un curso existente")
        void shouldUpdateCourse() {
            // Configuración
            when(courseMapper.toDomain(courseDto)).thenReturn(courseDomain);
            when(courseInPort.updateCourse(courseId, courseDomain)).thenReturn(courseDomain);
            when(courseMapper.toDto(courseDomain)).thenReturn(courseDto);

            // Ejecución
            ResponseEntity<Course> response = cursosWebAdapter.coursesIdPut(courseId, courseDto);

            // Verificación
            assertEquals(HttpStatus.OK, response.getStatusCode());
            verify(courseInPort).updateCourse(courseId, courseDomain);
        }
    }

    @Nested
    @DisplayName("Pruebas para coursesIdDelete")
    class CoursesIdDeleteTests {
        @Test
        @DisplayName("Debería eliminar un curso y retornar No Content")
        void shouldDeleteCourse() {
            // Ejecución
            ResponseEntity<Void> response = cursosWebAdapter.coursesIdDelete(courseId);

            // Verificación
            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
            verify(courseInPort).deleteCourse(courseId);
        }
    }

    @Nested
    @DisplayName("Pruebas para coursesIdSyllabusGet")
    class SyllabusGetTests {
        @Test
        @DisplayName("Debería obtener el temario (Syllabus) de un curso")
        void shouldGetSyllabus() {
            // Configuración
            courseDto.setSyllabus(Arrays.asList(new Syllabus()));
            when(courseInPort.getCourseById(courseId)).thenReturn(courseDomain);
            when(courseMapper.toDto(courseDomain)).thenReturn(courseDto);

            // Ejecución
            ResponseEntity<List<Syllabus>> response = cursosWebAdapter.coursesIdSyllabusGet(courseId);

            // Verificación
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().size());
        }
    }
}
