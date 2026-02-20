package com.growup.backend.domain.port.in;

import com.growup.backend.domain.model.Course;

import java.util.List;
import java.util.UUID;

/**
 * Puerto de Entrada para los casos de uso de Cursos.
 */
public interface CourseInPort {
    List<Course> getAllCourses(String category, String level, String status);

    Course getCourseById(UUID id);

    Course createCourse(Course course, UUID instructorId);

    Course updateCourse(UUID id, Course course);

    void deleteCourse(UUID id);

    List<Course> getCoursesByInstructor(UUID instructorId);
}
