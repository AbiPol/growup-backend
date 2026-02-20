package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Notification;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.NotificationJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class NotificationPersistenceMapperImpl implements NotificationPersistenceMapper {

    @Autowired
    private UserPersistenceMapper userPersistenceMapper;

    @Override
    public Notification toDomain(NotificationJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Notification.NotificationBuilder notification = Notification.builder();

        notification.id( entity.getId() );
        notification.user( userPersistenceMapper.toDomain( entity.getUser() ) );
        notification.title( entity.getTitle() );
        notification.message( entity.getMessage() );
        notification.date( entity.getDate() );
        notification.read( entity.getRead() );
        notification.link( map( entity.getLink() ) );

        notification.type( mapType(entity.getType()) );

        return notification.build();
    }

    @Override
    public NotificationJpaEntity toEntity(Notification domain) {
        if ( domain == null ) {
            return null;
        }

        NotificationJpaEntity.NotificationJpaEntityBuilder notificationJpaEntity = NotificationJpaEntity.builder();

        notificationJpaEntity.id( domain.getId() );
        notificationJpaEntity.user( userPersistenceMapper.toEntity( domain.getUser() ) );
        notificationJpaEntity.title( domain.getTitle() );
        notificationJpaEntity.message( domain.getMessage() );
        notificationJpaEntity.date( domain.getDate() );
        notificationJpaEntity.read( domain.getRead() );
        notificationJpaEntity.link( map( domain.getLink() ) );

        notificationJpaEntity.type( mapType(domain.getType()) );

        return notificationJpaEntity.build();
    }
}
