package com.acme.webserviceslinerepair.infrastructure.mapping;

import com.acme.webserviceslinerepair.shared.mapping.EnhancedModelMapper;
import com.acme.webserviceslinerepair.domain.model.Technician;
import com.acme.webserviceslinerepair.infrastructure.resource.CreateTechnicianResource;
import com.acme.webserviceslinerepair.infrastructure.resource.TechnicianResource;
import com.acme.webserviceslinerepair.infrastructure.resource.UpdateTechnicianResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TechnicianMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public TechnicianResource toResource(Technician model){
        return mapper.map(model, TechnicianResource.class);
    }

    public java.util.List<TechnicianResource> toResource(java.util.List<Technician> model){
        return mapper.mapList(model, TechnicianResource.class);
    }

    public Technician toModel(CreateTechnicianResource resource){
        return mapper.map(resource, Technician.class);
    }

    public Technician toModel(UpdateTechnicianResource resource){
        return mapper.map(resource, Technician.class);
    }

    public Page<TechnicianResource> modelListToPage(List<Technician> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, TechnicianResource.class), pageable, modelList.size());
    }
}
