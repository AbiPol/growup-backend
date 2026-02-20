package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Topic;
import com.growup.backend.model.CourseItem;
import com.growup.backend.model.CourseLevel;
import com.growup.backend.model.CourseStatus;
import com.growup.backend.model.Syllabus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:24+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CourseWebMapperImpl implements CourseWebMapper {

    @Autowired
    private UserWebMapper userWebMapper;

    @Override
    public com.growup.backend.model.Course toDto(Course domain) {
        if ( domain == null ) {
            return null;
        }

        com.growup.backend.model.Course course = new com.growup.backend.model.Course();

        course.setSyllabus( courseModuleListToSyllabusList( domain.getSyllabus() ) );
        course.setId( domain.getId() );
        course.setName( domain.getName() );
        course.setDescription( domain.getDescription() );
        course.setImageUrl( domain.getImageUrl() );
        course.setCategory( domain.getCategory() );
        if ( domain.getLevel() != null ) {
            course.setLevel( Enum.valueOf( CourseLevel.class, domain.getLevel() ) );
        }
        course.setPrice( domain.getPrice() );
        course.setDuration( domain.getDuration() );
        course.setStartDate( domain.getStartDate() );
        course.setEndDate( domain.getEndDate() );
        if ( domain.getPublicationStatus() != null ) {
            course.setPublicationStatus( Enum.valueOf( CourseStatus.class, domain.getPublicationStatus() ) );
        }
        course.setCreatedAt( domain.getCreatedAt() );
        course.setUpdatedAt( domain.getUpdatedAt() );
        course.setInstructor( userWebMapper.toInstructorDto( domain.getInstructor() ) );
        course.setEnrolledCount( domain.getEnrolledCount() );
        course.setVersion( domain.getVersion() );

        return course;
    }

    @Override
    public Course toDomain(com.growup.backend.model.Course dto) {
        if ( dto == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.id( dto.getId() );
        course.name( dto.getName() );
        course.description( dto.getDescription() );
        course.imageUrl( dto.getImageUrl() );
        course.category( dto.getCategory() );
        if ( dto.getLevel() != null ) {
            course.level( dto.getLevel().name() );
        }
        course.price( dto.getPrice() );
        course.duration( dto.getDuration() );
        course.startDate( dto.getStartDate() );
        course.endDate( dto.getEndDate() );
        if ( dto.getPublicationStatus() != null ) {
            course.publicationStatus( dto.getPublicationStatus().name() );
        }
        course.syllabus( syllabusListToCourseModuleList( dto.getSyllabus() ) );

        return course.build();
    }

    @Override
    public CourseItem toCourseItemDto(Course domain) {
        if ( domain == null ) {
            return null;
        }

        CourseItem courseItem = new CourseItem();

        courseItem.setSyllabus( courseModuleListToSyllabusList( domain.getSyllabus() ) );
        courseItem.setStudents( domain.getEnrolledCount() );
        courseItem.setId( domain.getId() );
        courseItem.setName( domain.getName() );
        courseItem.setDescription( domain.getDescription() );
        courseItem.setImageUrl( domain.getImageUrl() );
        courseItem.setCategory( domain.getCategory() );
        if ( domain.getLevel() != null ) {
            courseItem.setLevel( Enum.valueOf( CourseLevel.class, domain.getLevel() ) );
        }
        courseItem.setPrice( domain.getPrice() );
        courseItem.setDuration( domain.getDuration() );
        courseItem.setStartDate( domain.getStartDate() );
        courseItem.setEndDate( domain.getEndDate() );
        if ( domain.getPublicationStatus() != null ) {
            courseItem.setPublicationStatus( Enum.valueOf( CourseStatus.class, domain.getPublicationStatus() ) );
        }
        courseItem.setCreatedAt( domain.getCreatedAt() );
        courseItem.setUpdatedAt( domain.getUpdatedAt() );
        courseItem.setInstructor( userWebMapper.toInstructorDto( domain.getInstructor() ) );
        courseItem.setEnrolledCount( domain.getEnrolledCount() );
        courseItem.setVersion( domain.getVersion() );

        return courseItem;
    }

    @Override
    public Syllabus toModuleDto(CourseModule domain) {
        if ( domain == null ) {
            return null;
        }

        Syllabus syllabus = new Syllabus();

        syllabus.setId( domain.getId() );
        syllabus.setTitle( domain.getTitle() );
        syllabus.setDescription( domain.getDescription() );
        syllabus.setTopics( topicListToTopicList( domain.getTopics() ) );

        return syllabus;
    }

    @Override
    public CourseModule toModuleDomain(Syllabus dto) {
        if ( dto == null ) {
            return null;
        }

        CourseModule.CourseModuleBuilder courseModule = CourseModule.builder();

        courseModule.id( dto.getId() );
        courseModule.title( dto.getTitle() );
        courseModule.description( dto.getDescription() );
        courseModule.topics( topicListToTopicList1( dto.getTopics() ) );

        return courseModule.build();
    }

    @Override
    public com.growup.backend.model.Topic toTopicDto(Topic domain) {
        if ( domain == null ) {
            return null;
        }

        com.growup.backend.model.Topic topic = new com.growup.backend.model.Topic();

        topic.setTitle( domain.getName() );
        if ( domain.getDuration() != null ) {
            topic.setDuration( Integer.parseInt( domain.getDuration() ) );
        }

        return topic;
    }

    @Override
    public Topic toTopicDomain(com.growup.backend.model.Topic dto) {
        if ( dto == null ) {
            return null;
        }

        Topic.TopicBuilder topic = Topic.builder();

        topic.name( dto.getTitle() );
        if ( dto.getDuration() != null ) {
            topic.duration( String.valueOf( dto.getDuration() ) );
        }

        return topic.build();
    }

    protected List<Syllabus> courseModuleListToSyllabusList(List<CourseModule> list) {
        if ( list == null ) {
            return null;
        }

        List<Syllabus> list1 = new ArrayList<Syllabus>( list.size() );
        for ( CourseModule courseModule : list ) {
            list1.add( toModuleDto( courseModule ) );
        }

        return list1;
    }

    protected List<CourseModule> syllabusListToCourseModuleList(List<Syllabus> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseModule> list1 = new ArrayList<CourseModule>( list.size() );
        for ( Syllabus syllabus : list ) {
            list1.add( toModuleDomain( syllabus ) );
        }

        return list1;
    }

    protected List<com.growup.backend.model.Topic> topicListToTopicList(List<Topic> list) {
        if ( list == null ) {
            return null;
        }

        List<com.growup.backend.model.Topic> list1 = new ArrayList<com.growup.backend.model.Topic>( list.size() );
        for ( Topic topic : list ) {
            list1.add( toTopicDto( topic ) );
        }

        return list1;
    }

    protected List<Topic> topicListToTopicList1(List<com.growup.backend.model.Topic> list) {
        if ( list == null ) {
            return null;
        }

        List<Topic> list1 = new ArrayList<Topic>( list.size() );
        for ( com.growup.backend.model.Topic topic : list ) {
            list1.add( toTopicDomain( topic ) );
        }

        return list1;
    }
}
