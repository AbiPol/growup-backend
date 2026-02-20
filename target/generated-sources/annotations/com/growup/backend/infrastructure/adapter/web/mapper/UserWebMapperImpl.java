package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.User;
import com.growup.backend.model.Instructor;
import com.growup.backend.model.RegisterRequest;
import com.growup.backend.model.UpdateUserRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserWebMapperImpl implements UserWebMapper {

    @Override
    public Instructor toInstructorDto(User domain) {
        if ( domain == null ) {
            return null;
        }

        Instructor instructor = new Instructor();

        instructor.setId( domain.getId() );
        instructor.setName( domain.getName() );
        if ( domain.getRole() != null ) {
            instructor.setRole( domain.getRole().name() );
        }
        instructor.setBio( domain.getBio() );

        instructor.setAvatarUrl( toUri(domain.getAvatar()) );

        return instructor;
    }

    @Override
    public com.growup.backend.model.User toDto(User domain) {
        if ( domain == null ) {
            return null;
        }

        com.growup.backend.model.User user = new com.growup.backend.model.User();

        user.setId( domain.getId() );
        user.setName( domain.getName() );
        user.setEmail( domain.getEmail() );
        user.setIsActive( domain.getIsActive() );
        user.setRole( mapRole( domain.getRole() ) );
        user.setJoinDate( domain.getJoinDate() );
        user.setBio( domain.getBio() );
        user.setVersion( domain.getVersion() );

        user.setAvatar( toUri(domain.getAvatar()) );

        return user;
    }

    @Override
    public User toDomain(com.growup.backend.model.User dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.name( dto.getName() );
        user.email( dto.getEmail() );
        user.isActive( dto.getIsActive() );
        user.role( mapRole( dto.getRole() ) );
        user.bio( dto.getBio() );
        user.joinDate( dto.getJoinDate() );
        user.version( dto.getVersion() );

        user.avatar( toString(dto.getAvatar()) );

        return user.build();
    }

    @Override
    public User instructorToDomain(Instructor dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.avatar( toString( dto.getAvatarUrl() ) );
        user.id( dto.getId() );
        user.name( dto.getName() );
        user.bio( dto.getBio() );

        return user.build();
    }

    @Override
    public User toDomain(RegisterRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public User toDomain(UpdateUserRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.bio( dto.getBio() );

        user.avatar( toString(dto.getAvatar()) );

        return user.build();
    }
}
