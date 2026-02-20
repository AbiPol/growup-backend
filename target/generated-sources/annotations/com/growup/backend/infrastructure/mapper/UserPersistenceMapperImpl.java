package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserPersistenceMapperImpl implements UserPersistenceMapper {

    @Override
    public User toDomain(UserJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.name( entity.getName() );
        user.email( entity.getEmail() );
        user.password( entity.getPassword() );
        user.isActive( entity.getIsActive() );
        user.role( entity.getRole() );
        user.bio( entity.getBio() );
        user.avatar( entity.getAvatar() );
        user.joinDate( entity.getJoinDate() );
        user.version( entity.getVersion() );

        return user.build();
    }

    @Override
    public UserJpaEntity toEntity(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserJpaEntity.UserJpaEntityBuilder userJpaEntity = UserJpaEntity.builder();

        userJpaEntity.id( domain.getId() );
        userJpaEntity.name( domain.getName() );
        userJpaEntity.email( domain.getEmail() );
        userJpaEntity.password( domain.getPassword() );
        userJpaEntity.isActive( domain.getIsActive() );
        userJpaEntity.role( domain.getRole() );
        userJpaEntity.bio( domain.getBio() );
        userJpaEntity.avatar( domain.getAvatar() );
        userJpaEntity.joinDate( domain.getJoinDate() );
        userJpaEntity.version( domain.getVersion() );

        return userJpaEntity.build();
    }
}
