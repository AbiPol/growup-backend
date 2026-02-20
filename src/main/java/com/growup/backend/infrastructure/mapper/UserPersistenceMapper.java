package com.growup.backend.infrastructure.mapper;

import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.adapter.persistence.jpa.entity.UserJpaEntity;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre el modelo de dominio User y la entidad JPA
 * UserJpaEntity.
 */
@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    User toDomain(UserJpaEntity entity);

    // @Mapping(target = "version", ignore = true)
    UserJpaEntity toEntity(User domain);
}
