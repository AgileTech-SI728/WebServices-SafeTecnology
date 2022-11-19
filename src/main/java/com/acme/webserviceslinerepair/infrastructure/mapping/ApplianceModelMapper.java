package com.acme.webserviceslinerepair.infrastructure.mapping;

import com.acme.webserviceslinerepair.domain.model.ApplianceModel;
import com.acme.webserviceslinerepair.infrastructure.resource.ApplianceModelResource;
import com.acme.webserviceslinerepair.infrastructure.resource.CreateApplianceModelResource;
import com.acme.webserviceslinerepair.infrastructure.resource.UpdateApplianceModelResource;
import com.acme.webserviceslinerepair.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ApplianceModelMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ApplianceModelResource toResource(ApplianceModel model){
        return mapper.map(model, ApplianceModelResource.class);
    }

    public List<ApplianceModelResource> toResource(List<ApplianceModel>model){
        return mapper.mapList(model, ApplianceModelResource.class);
    }

    public ApplianceModel toModel(CreateApplianceModelResource resource){
        return mapper.map(resource, ApplianceModel.class);
    }

    public ApplianceModel toModel(UpdateApplianceModelResource resource){
        return mapper.map(resource, ApplianceModel.class);
    }

    public Page<ApplianceModelResource> modelListToPage(List<ApplianceModel> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ApplianceModelResource.class), pageable, modelList.size());
    }
}
