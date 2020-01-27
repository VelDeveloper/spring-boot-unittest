package com.example.springbootunittest.assembler;

import com.example.springbootunittest.controller.CapabilityController;
import com.example.springbootunittest.model.Capability;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CapabilityResourceAssembler implements RepresentationModelAssembler<Capability, EntityModel<Capability>> {

    @Override
    public EntityModel<Capability> toModel(Capability entity) {
        return new EntityModel<>(entity,
                linkTo(methodOn(CapabilityController.class).getCapabilityById(entity.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"),
                linkTo(methodOn(CapabilityController.class).deleteCapability(entity.getId())).withRel("deleteThisCapability")
        );
    }
}
