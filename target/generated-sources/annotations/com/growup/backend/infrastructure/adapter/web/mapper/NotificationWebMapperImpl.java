package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.Notification;
import com.growup.backend.domain.model.User;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:24+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class NotificationWebMapperImpl implements NotificationWebMapper {

    @Override
    public com.growup.backend.model.Notification toDto(Notification domain) {
        if ( domain == null ) {
            return null;
        }

        com.growup.backend.model.Notification notification = new com.growup.backend.model.Notification();

        notification.setUserId( domainUserId( domain ) );
        notification.setId( domain.getId() );
        notification.setTitle( domain.getTitle() );
        notification.setMessage( domain.getMessage() );
        notification.setDate( domain.getDate() );
        notification.setRead( domain.getRead() );
        notification.setLink( domain.getLink() );

        notification.setType( mapType(domain.getType()) );

        return notification;
    }

    @Override
    public Notification toDomain(com.growup.backend.model.Notification dto) {
        if ( dto == null ) {
            return null;
        }

        Notification.NotificationBuilder notification = Notification.builder();

        notification.user( notificationToUser( dto ) );
        notification.id( dto.getId() );
        notification.title( dto.getTitle() );
        notification.message( dto.getMessage() );
        notification.date( dto.getDate() );
        notification.read( dto.getRead() );
        notification.link( dto.getLink() );

        notification.type( mapType(dto.getType()) );

        return notification.build();
    }

    private UUID domainUserId(Notification notification) {
        if ( notification == null ) {
            return null;
        }
        User user = notification.getUser();
        if ( user == null ) {
            return null;
        }
        UUID id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User notificationToUser(com.growup.backend.model.Notification notification) {
        if ( notification == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( notification.getUserId() );

        return user.build();
    }
}
