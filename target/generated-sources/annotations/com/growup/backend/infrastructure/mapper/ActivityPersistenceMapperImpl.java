package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Activity;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.ActivityJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ActivityPersistenceMapperImpl implements ActivityPersistenceMapper {

    @Autowired
    private UserPersistenceMapper userPersistenceMapper;

    @Override
    public Activity toDomain(ActivityJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Activity.ActivityBuilder activity = Activity.builder();

        activity.id( entity.getId() );
        activity.user( userPersistenceMapper.toDomain( entity.getUser() ) );
        activity.action( entity.getAction() );
        activity.target( entity.getTarget() );
        activity.time( entity.getTime() );

        activity.type( mapType(entity.getType()) );

        return activity.build();
    }

    @Override
    public ActivityJpaEntity toEntity(Activity domain) {
        if ( domain == null ) {
            return null;
        }

        ActivityJpaEntity.ActivityJpaEntityBuilder activityJpaEntity = ActivityJpaEntity.builder();

        activityJpaEntity.id( domain.getId() );
        activityJpaEntity.user( userPersistenceMapper.toEntity( domain.getUser() ) );
        activityJpaEntity.action( domain.getAction() );
        activityJpaEntity.target( domain.getTarget() );
        activityJpaEntity.time( domain.getTime() );

        activityJpaEntity.type( mapType(domain.getType()) );

        return activityJpaEntity.build();
    }
}
