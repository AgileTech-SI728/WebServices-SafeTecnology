package com.acme.webserviceslinerepair.security.mapping;

import com.acme.webserviceslinerepair.security.domain.model.entity.Role;
import com.acme.webserviceslinerepair.security.domain.model.enumeration.Roles;
import com.acme.webserviceslinerepair.security.resource.RoleResource;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.acme.webserviceslinerepair.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class RoleMapper {
    @Autowired
    EnhancedModelMapper mapper;

    Converter<Roles, String> rolesToString = new AbstractConverter<>() {
        @Override
        protected String convert(Roles role) {
            return role == null ? null : role.name();
        }
    };


    // Object Mapping
    public RoleResource toResource(Role model) {
        mapper.addConverter(rolesToString);
        return mapper.map(model, RoleResource.class);
    }

    public Page<RoleResource> modelListToPage(List<Role> modelList, Pageable pageable) {
        mapper.addConverter(rolesToString);
        return new PageImpl<>(mapper.mapList(modelList, RoleResource.class), pageable, modelList.size());
    }
}