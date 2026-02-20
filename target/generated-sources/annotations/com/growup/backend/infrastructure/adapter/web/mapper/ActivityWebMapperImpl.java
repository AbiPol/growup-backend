package com.growup.backend.infrastructure.adapter.web.mapper;

import com.growup.backend.domain.model.User;
import com.growup.backend.model.Activity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ActivityWebMapperImpl implements ActivityWebMapper {

    @Override
    public Activity toDto(com.growup.backend.domain.model.Activity domain) {
        if ( domain == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setUser( domainUserName( domain ) );
        activity.setId( domain.getId() );
        activity.setAction( domain.getAction() );
        activity.setTarget( domain.getTarget() );
        activity.setTime( domain.getTime() );

        activity.setType( mapType(domain.getType()) );

        return activity;
    }

    @Override
    public com.growup.backend.domain.model.Activity toDomain(Activity dto) {
        if ( dto == null ) {
            return null;
        }

        com.growup.backend.domain.model.Activity.ActivityBuilder activity = com.growup.backend.domain.model.Activity.builder();

        activity.id( dto.getId() );
        activity.action( dto.getAction() );
        activity.target( dto.getTarget() );
        activity.time( dto.getTime() );

        activity.type( mapType(dto.getType()) );

        return activity.build();
    }

    private String domainUserName(com.growup.backend.domain.model.Activity activity) {
        if ( activity == null ) {
            return null;
        }
        User user = activity.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
