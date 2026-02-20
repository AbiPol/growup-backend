package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.Enrollment;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.EnrollmentJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-20T14:24:25+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class EnrollmentPersistenceMapperImpl implements EnrollmentPersistenceMapper {

    @Autowired
    private CoursePersistenceMapper coursePersistenceMapper;

    @Override
    public Enrollment toDomain(EnrollmentJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Enrollment.EnrollmentBuilder enrollment = Enrollment.builder();

        enrollment.id( entity.getId() );
        enrollment.course( coursePersistenceMapper.toDomain( entity.getCourse() ) );
        enrollment.progress( entity.getProgress() );
        enrollment.lastAccessDate( entity.getLastAccessDate() );
        enrollment.nextLessonId( entity.getNextLessonId() );
        enrollment.version( entity.getVersion() );

        enrollment.enrollmentStatus( mapStatus(entity.getEnrollmentStatus()) );

        return enrollment.build();
    }

    @Override
    public EnrollmentJpaEntity toEntity(Enrollment domain) {
        if ( domain == null ) {
            return null;
        }

        EnrollmentJpaEntity.EnrollmentJpaEntityBuilder enrollmentJpaEntity = EnrollmentJpaEntity.builder();

        enrollmentJpaEntity.id( domain.getId() );
        enrollmentJpaEntity.course( coursePersistenceMapper.toEntity( domain.getCourse() ) );
        enrollmentJpaEntity.progress( domain.getProgress() );
        enrollmentJpaEntity.lastAccessDate( domain.getLastAccessDate() );
        enrollmentJpaEntity.nextLessonId( domain.getNextLessonId() );
        enrollmentJpaEntity.version( domain.getVersion() );

        enrollmentJpaEntity.enrollmentStatus( mapStatus(domain.getEnrollmentStatus()) );

        return enrollmentJpaEntity.build();
    }
}
