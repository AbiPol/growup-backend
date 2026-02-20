package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.domain.model.StudentStats;
import com.growup.backend.domain.model.User;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.EnrolledCourse;
import com.growup.backend.model.EnrollmentStatus;
import com.growup.backend.model.Syllabus;
import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class EnrollmentWebMapperImpl implements EnrollmentWebMapper {

    @Autowired
    private UserWebMapper userWebMapper;
    @Autowired
    private CourseWebMapper courseWebMapper;

    @Override
    public EnrolledCourse toDto(Enrollment domain) {
        if ( domain == null ) {
            return null;
        }

        EnrolledCourse enrolledCourse = new EnrolledCourse();

        enrolledCourse.setName( domainCourseName( domain ) );
        enrolledCourse.setDescription( domainCourseDescription( domain ) );
        enrolledCourse.setImageUrl( domainCourseImageUrl( domain ) );
        enrolledCourse.setCategory( domainCourseCategory( domain ) );
        String level = domainCourseLevel( domain );
        if ( level != null ) {
            enrolledCourse.setLevel( Enum.valueOf( CourseLevel.class, level ) );
        }
        enrolledCourse.setPrice( domainCoursePrice( domain ) );
        enrolledCourse.setDuration( domainCourseDuration( domain ) );
        enrolledCourse.setStartDate( domainCourseStartDate( domain ) );
        enrolledCourse.setEndDate( domainCourseEndDate( domain ) );
        String publicationStatus = domainCoursePublicationStatus( domain );
        if ( publicationStatus != null ) {
            enrolledCourse.setPublicationStatus( Enum.valueOf( CourseStatus.class, publicationStatus ) );
        }
        enrolledCourse.setCreatedAt( domainCourseCreatedAt( domain ) );
        enrolledCourse.setUpdatedAt( domainCourseUpdatedAt( domain ) );
        enrolledCourse.setInstructor( userWebMapper.toInstructorDto( domainCourseInstructor( domain ) ) );
        List<CourseModule> syllabus = domainCourseSyllabus( domain );
        enrolledCourse.setSyllabus( courseModuleListToSyllabusList( syllabus ) );
        enrolledCourse.setEnrolledCount( domainCourseEnrolledCount( domain ) );
        enrolledCourse.setId( domain.getId() );
        enrolledCourse.setVersion( domain.getVersion() );
        enrolledCourse.setProgress( domain.getProgress() );
        enrolledCourse.setLastAccessDate( domain.getLastAccessDate() );
        if ( domain.getEnrollmentStatus() != null ) {
            enrolledCourse.setEnrollmentStatus( Enum.valueOf( EnrollmentStatus.class, domain.getEnrollmentStatus() ) );
        }
        enrolledCourse.setNextLessonId( domain.getNextLessonId() );

        return enrolledCourse;
    }

    @Override
    public Enrollment toDomain(EnrolledCourse dto) {
        if ( dto == null ) {
            return null;
        }

        Enrollment.EnrollmentBuilder enrollment = Enrollment.builder();

        enrollment.course( enrolledCourseToCourse( dto ) );
        enrollment.id( dto.getId() );
        enrollment.progress( dto.getProgress() );
        enrollment.lastAccessDate( dto.getLastAccessDate() );
        if ( dto.getEnrollmentStatus() != null ) {
            enrollment.enrollmentStatus( dto.getEnrollmentStatus().name() );
        }
        enrollment.nextLessonId( dto.getNextLessonId() );

        return enrollment.build();
    }

    @Override
    public com.growup.backend.model.StudentStats toStatsDto(StudentStats domain) {
        if ( domain == null ) {
            return null;
        }

        com.growup.backend.model.StudentStats studentStats = new com.growup.backend.model.StudentStats();

        studentStats.setActiveCoursesCount( domain.getActiveCoursesCount() );
        studentStats.setCompletedCoursesCount( domain.getCompletedCoursesCount() );
        studentStats.setCertificatesEarned( domain.getCertificatesEarned() );
        studentStats.setTotalHoursLearning( domain.getTotalHoursLearning() );
        studentStats.setAverageScore( domain.getAverageScore() );
        studentStats.setLearningStreakDays( domain.getLearningStreakDays() );

        return studentStats;
    }

    private String domainCourseName(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        String name = course.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String domainCourseDescription(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        String description = course.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private URI domainCourseImageUrl(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        URI imageUrl = course.getImageUrl();
        if ( imageUrl == null ) {
            return null;
        }
        return imageUrl;
    }

    private String domainCourseCategory(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        String category = course.getCategory();
        if ( category == null ) {
            return null;
        }
        return category;
    }

    private String domainCourseLevel(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        String level = course.getLevel();
        if ( level == null ) {
            return null;
        }
        return level;
    }

    private Double domainCoursePrice(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        Double price = course.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private BigDecimal domainCourseDuration(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        BigDecimal duration = course.getDuration();
        if ( duration == null ) {
            return null;
        }
        return duration;
    }

    private OffsetDateTime domainCourseStartDate(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        OffsetDateTime startDate = course.getStartDate();
        if ( startDate == null ) {
            return null;
        }
        return startDate;
    }

    private OffsetDateTime domainCourseEndDate(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        OffsetDateTime endDate = course.getEndDate();
        if ( endDate == null ) {
            return null;
        }
        return endDate;
    }

    private String domainCoursePublicationStatus(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        String publicationStatus = course.getPublicationStatus();
        if ( publicationStatus == null ) {
            return null;
        }
        return publicationStatus;
    }

    private OffsetDateTime domainCourseCreatedAt(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        OffsetDateTime createdAt = course.getCreatedAt();
        if ( createdAt == null ) {
            return null;
        }
        return createdAt;
    }

    private OffsetDateTime domainCourseUpdatedAt(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        OffsetDateTime updatedAt = course.getUpdatedAt();
        if ( updatedAt == null ) {
            return null;
        }
        return updatedAt;
    }

    private User domainCourseInstructor(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        User instructor = course.getInstructor();
        if ( instructor == null ) {
            return null;
        }
        return instructor;
    }

    private List<CourseModule> domainCourseSyllabus(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        List<CourseModule> syllabus = course.getSyllabus();
        if ( syllabus == null ) {
            return null;
        }
        return syllabus;
    }

    protected List<Syllabus> courseModuleListToSyllabusList(List<CourseModule> list) {
        if ( list == null ) {
            return null;
        }

        List<Syllabus> list1 = new ArrayList<Syllabus>( list.size() );
        for ( CourseModule courseModule : list ) {
            list1.add( courseWebMapper.toModuleDto( courseModule ) );
        }

        return list1;
    }

    private Integer domainCourseEnrolledCount(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        Integer enrolledCount = course.getEnrolledCount();
        if ( enrolledCount == null ) {
            return null;
        }
        return enrolledCount;
    }

    protected List<CourseModule> syllabusListToCourseModuleList(List<Syllabus> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseModule> list1 = new ArrayList<CourseModule>( list.size() );
        for ( Syllabus syllabus : list ) {
            list1.add( courseWebMapper.toModuleDomain( syllabus ) );
        }

        return list1;
    }

    protected Course enrolledCourseToCourse(EnrolledCourse enrolledCourse) {
        if ( enrolledCourse == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.name( enrolledCourse.getName() );
        course.description( enrolledCourse.getDescription() );
        course.imageUrl( enrolledCourse.getImageUrl() );
        course.category( enrolledCourse.getCategory() );
        if ( enrolledCourse.getLevel() != null ) {
            course.level( enrolledCourse.getLevel().name() );
        }
        course.price( enrolledCourse.getPrice() );
        course.duration( enrolledCourse.getDuration() );
        course.startDate( enrolledCourse.getStartDate() );
        course.endDate( enrolledCourse.getEndDate() );
        if ( enrolledCourse.getPublicationStatus() != null ) {
            course.publicationStatus( enrolledCourse.getPublicationStatus().name() );
        }
        course.createdAt( enrolledCourse.getCreatedAt() );
        course.updatedAt( enrolledCourse.getUpdatedAt() );
        course.instructor( userWebMapper.instructorToDomain( enrolledCourse.getInstructor() ) );
        course.syllabus( syllabusListToCourseModuleList( enrolledCourse.getSyllabus() ) );
        course.enrolledCount( enrolledCourse.getEnrolledCount() );

        return course.build();
    }
}
