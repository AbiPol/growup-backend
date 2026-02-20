package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Course;
import com.growup.backend.domain.model.CourseModule;
import com.growup.backend.domain.model.Topic;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.CourseModuleJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.TopicJpaEntity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.UserJpaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:24+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CoursePersistenceMapperImpl implements CoursePersistenceMapper {

    @Override
    public Course toDomain(CourseJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.syllabus( courseModuleJpaEntityListToCourseModuleList( entity.getSyllabus() ) );
        course.id( entity.getId() );
        course.name( entity.getName() );
        course.description( entity.getDescription() );
        course.category( entity.getCategory() );
        course.price( entity.getPrice() );
        course.duration( entity.getDuration() );
        course.startDate( entity.getStartDate() );
        course.endDate( entity.getEndDate() );
        course.createdAt( entity.getCreatedAt() );
        course.updatedAt( entity.getUpdatedAt() );
        course.instructor( userJpaEntityToUser( entity.getInstructor() ) );
        course.enrolledCount( entity.getEnrolledCount() );
        course.version( entity.getVersion() );

        course.level( mapLevel(entity.getLevel()) );
        course.publicationStatus( mapStatus(entity.getPublicationStatus()) );
        course.imageUrl( toUri(entity.getImageUrl()) );

        return course.build();
    }

    @Override
    public CourseJpaEntity toEntity(Course domain) {
        if ( domain == null ) {
            return null;
        }

        CourseJpaEntity.CourseJpaEntityBuilder courseJpaEntity = CourseJpaEntity.builder();

        courseJpaEntity.syllabus( courseModuleListToCourseModuleJpaEntityList( domain.getSyllabus() ) );
        courseJpaEntity.id( domain.getId() );
        courseJpaEntity.name( domain.getName() );
        courseJpaEntity.description( domain.getDescription() );
        courseJpaEntity.category( domain.getCategory() );
        courseJpaEntity.price( domain.getPrice() );
        courseJpaEntity.duration( domain.getDuration() );
        courseJpaEntity.startDate( domain.getStartDate() );
        courseJpaEntity.endDate( domain.getEndDate() );
        courseJpaEntity.createdAt( domain.getCreatedAt() );
        courseJpaEntity.updatedAt( domain.getUpdatedAt() );
        courseJpaEntity.enrolledCount( domain.getEnrolledCount() );

        courseJpaEntity.level( mapLevel(domain.getLevel()) );
        courseJpaEntity.publicationStatus( mapStatus(domain.getPublicationStatus()) );
        courseJpaEntity.imageUrl( toString(domain.getImageUrl()) );

        return courseJpaEntity.build();
    }

    @Override
    public CourseModule toDomainModule(CourseModuleJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CourseModule.CourseModuleBuilder courseModule = CourseModule.builder();

        courseModule.id( entity.getId() );
        courseModule.title( entity.getTitle() );
        courseModule.description( entity.getDescription() );
        courseModule.topics( topicJpaEntityListToTopicList( entity.getTopics() ) );

        return courseModule.build();
    }

    @Override
    public CourseModuleJpaEntity toEntityModule(CourseModule domain) {
        if ( domain == null ) {
            return null;
        }

        CourseModuleJpaEntity.CourseModuleJpaEntityBuilder courseModuleJpaEntity = CourseModuleJpaEntity.builder();

        courseModuleJpaEntity.id( domain.getId() );
        courseModuleJpaEntity.title( domain.getTitle() );
        courseModuleJpaEntity.description( domain.getDescription() );
        courseModuleJpaEntity.topics( topicListToTopicJpaEntityList( domain.getTopics() ) );

        return courseModuleJpaEntity.build();
    }

    @Override
    public Topic toDomainTopic(TopicJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Topic.TopicBuilder topic = Topic.builder();

        topic.duration( mapDuration(entity.getDuration()) );

        return topic.build();
    }

    @Override
    public TopicJpaEntity toEntityTopic(Topic domain) {
        if ( domain == null ) {
            return null;
        }

        TopicJpaEntity.TopicJpaEntityBuilder topicJpaEntity = TopicJpaEntity.builder();

        topicJpaEntity.duration( mapDuration(domain.getDuration()) );

        return topicJpaEntity.build();
    }

    protected List<CourseModule> courseModuleJpaEntityListToCourseModuleList(List<CourseModuleJpaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseModule> list1 = new ArrayList<CourseModule>( list.size() );
        for ( CourseModuleJpaEntity courseModuleJpaEntity : list ) {
            list1.add( toDomainModule( courseModuleJpaEntity ) );
        }

        return list1;
    }

    protected User userJpaEntityToUser(UserJpaEntity userJpaEntity) {
        if ( userJpaEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userJpaEntity.getId() );
        user.name( userJpaEntity.getName() );
        user.email( userJpaEntity.getEmail() );
        user.password( userJpaEntity.getPassword() );
        user.isActive( userJpaEntity.getIsActive() );
        user.role( userJpaEntity.getRole() );
        user.bio( userJpaEntity.getBio() );
        user.avatar( userJpaEntity.getAvatar() );
        user.joinDate( userJpaEntity.getJoinDate() );
        user.version( userJpaEntity.getVersion() );

        return user.build();
    }

    protected List<CourseModuleJpaEntity> courseModuleListToCourseModuleJpaEntityList(List<CourseModule> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseModuleJpaEntity> list1 = new ArrayList<CourseModuleJpaEntity>( list.size() );
        for ( CourseModule courseModule : list ) {
            list1.add( toEntityModule( courseModule ) );
        }

        return list1;
    }

    protected List<Topic> topicJpaEntityListToTopicList(List<TopicJpaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Topic> list1 = new ArrayList<Topic>( list.size() );
        for ( TopicJpaEntity topicJpaEntity : list ) {
            list1.add( toDomainTopic( topicJpaEntity ) );
        }

        return list1;
    }

    protected List<TopicJpaEntity> topicListToTopicJpaEntityList(List<Topic> list) {
        if ( list == null ) {
            return null;
        }

        List<TopicJpaEntity> list1 = new ArrayList<TopicJpaEntity>( list.size() );
        for ( Topic topic : list ) {
            list1.add( toEntityTopic( topic ) );
        }

        return list1;
    }
}
