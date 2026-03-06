package com.growup.backend.application.service;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Topic;
import com.growup.backend.domain.model.User;
import com.growup.backend.domain.port.out.CoursePersistencePort;
import com.growup.backend.domain.port.out.UserPersistencePort;
import com.growup.backend.infrastructure.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para el servicio CourseService.
 * Utiliza Mockito para simular los puertos de persistencia.
 */
@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CoursePersistencePort coursePersistencePort;

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private CourseService courseService;

    private UUID courseId;
    private UUID instructorId;
    private Course sampleCourse;
    private User instructor;

    @BeforeEach
    void setUp() {
        courseId = UUID.randomUUID();
        instructorId = UUID.randomUUID();

        instructor = User.builder()
                .id(instructorId)
                .name("Instructor de Prueba")
                .email("instructor@prueba.com")
                .build();

        sampleCourse = Course.builder()
                .id(courseId)
                .name("Pruebas Unitarias con Java")
                .description("Aprende JUnit y Mockito paso a paso")
                .instructor(instructor)
                .syllabus(new ArrayList<>())
                .build();
    }

    @Nested
    @DisplayName("Pruebas para obtener todos los cursos (getAllCourses)")
    class GetAllCoursesTests {
        @Test
        @DisplayName("Debería devolver la lista de cursos cuando se encuentran resultados")
        void shouldReturnCoursesWhenFound() {
            // Configuración
            when(coursePersistencePort.findByFilters(any(), any(), any(), any()))
                    .thenReturn(Arrays.asList(sampleCourse));

            // Ejecución
            List<Course> result = courseService.getAllCourses(instructorId, null, null, null);

            // Verificación
            assertFalse(result.isEmpty());
            assertEquals(1, result.size());
            assertEquals(sampleCourse.getName(), result.get(0).getName());
            verify(coursePersistencePort).findByFilters(any(), any(), any(), any());
        }

        @Test
        @DisplayName("Debería devolver lista vacía cuando no se encuentran cursos")
        void shouldReturnEmptyListWhenNoCoursesFound() {
            // Configuración
            when(coursePersistencePort.findByFilters(any(), any(), any(), any()))
                    .thenReturn(Collections.emptyList());

            // Ejecución
            List<Course> result = courseService.getAllCourses(instructorId, null, null, null);

            // Verificación
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    @DisplayName("Pruebas para obtener curso por ID (getCourseById)")
    class GetCourseByIdTests {
        @Test
        @DisplayName("Debería devolver el curso cuando el ID existe")
        void shouldReturnCourseWhenIdExists() {
            // Configuración
            when(coursePersistencePort.findById(courseId)).thenReturn(Optional.of(sampleCourse));

            // Ejecución
            Course result = courseService.getCourseById(courseId);

            // Verificación
            assertNotNull(result);
            assertEquals(courseId, result.getId());
        }

        @Test
        @DisplayName("Debería lanzar ResourceNotFoundException cuando el ID no existe")
        void shouldThrowExceptionWhenIdDoesNotExist() {
            // Configuración
            when(coursePersistencePort.findById(courseId)).thenReturn(Optional.empty());

            // Ejecución y Verificación
            assertThrows(ResourceNotFoundException.class, () -> courseService.getCourseById(courseId));
        }
    }

    @Nested
    @DisplayName("Pruebas para creación de cursos (createCourse)")
    class CreateCourseTests {
        @Test
        @DisplayName("Debería crear el curso correctamente cuando el instructor existe")
        void shouldCreateCourseSuccessfully() {
            // Configuración
            when(userPersistencePort.findById(instructorId)).thenReturn(Optional.of(instructor));
            when(coursePersistencePort.save(any(Course.class))).thenAnswer(invocation -> invocation.getArgument(0));

            // Ejecución
            Course result = courseService.createCourse(sampleCourse, instructorId);

            // Verificación
            assertNotNull(result);
            assertEquals(instructor, result.getInstructor());
            verify(coursePersistencePort).save(sampleCourse);
        }

        @Test
        @DisplayName("Debería lanzar ResourceNotFoundException cuando el instructor no existe")
        void shouldThrowExceptionWhenInstructorNotFound() {
            // Configuración
            when(userPersistencePort.findById(instructorId)).thenReturn(Optional.empty());

            // Ejecución y Verificación
            assertThrows(ResourceNotFoundException.class, () -> courseService.createCourse(sampleCourse, instructorId));

            verify(coursePersistencePort, never()).save(any());
        }
    }

    @Nested
    @DisplayName("Pruebas para actualización de cursos (updateCourse)")
    class UpdateCourseTests {
        @Test
        @DisplayName("Debería actualizar los campos básicos correctamente")
        void shouldUpdateBasicFields() {
            // Configuración
            when(coursePersistencePort.findById(courseId)).thenReturn(Optional.of(sampleCourse));
            when(coursePersistencePort.save(any(Course.class))).thenAnswer(invocation -> invocation.getArgument(0));

            Course updatedData = Course.builder()
                    .name("Nombre Nuevo")
                    .description("Descripción Nueva")
                    .build();

            // Ejecución
            Course result = courseService.updateCourse(courseId, updatedData);

            // Verificación
            assertEquals("Nombre Nuevo", result.getName());
            assertEquals("Descripción Nueva", result.getDescription());
        }

        @Test
        @DisplayName("Debería mantener las versiones del temario (Syllabus) durante la actualización")
        void shouldMaintainSyllabusVersions() {
            // Configuración
            UUID moduleId = UUID.randomUUID();
            Topic existingTopic = Topic.builder().id(UUID.randomUUID()).name("Tema Original").version(10L).build();
            CourseModule existingModule = CourseModule.builder()
                    .id(moduleId)
                    .title("Módulo Original")
                    .version(5L)
                    .topics(new ArrayList<>(Arrays.asList(existingTopic)))
                    .build();

            sampleCourse.setSyllabus(new ArrayList<>(Arrays.asList(existingModule)));

            when(coursePersistencePort.findById(courseId)).thenReturn(Optional.of(sampleCourse));
            when(coursePersistencePort.save(any(Course.class))).thenAnswer(invocation -> invocation.getArgument(0));

            // Simulación de datos recibidos (sin versiones)
            Topic updatedTopic = Topic.builder().id(existingTopic.getId()).name("Tema Modificado").build();
            CourseModule updatedModule = CourseModule.builder()
                    .id(moduleId)
                    .title("Módulo Modificado")
                    .topics(new ArrayList<>(Arrays.asList(updatedTopic)))
                    .build();

            Course dataToUpdate = Course.builder()
                    .syllabus(new ArrayList<>(Arrays.asList(updatedModule)))
                    .build();

            // Ejecución
            Course result = courseService.updateCourse(courseId, dataToUpdate);

            // Verificamos que se hayan recuperado las versiones
            assertEquals(5L, result.getSyllabus().get(0).getVersion());
            assertEquals(10L, result.getSyllabus().get(0).getTopics().get(0).getVersion());
        }
    }

    @Test
    @DisplayName("Debería invocar la eliminación en el puerto de persistencia")
    void shouldDeleteCourse() {
        // Ejecución
        courseService.deleteCourse(courseId);

        // Verificación
        verify(coursePersistencePort).delete(courseId);
    }
}
