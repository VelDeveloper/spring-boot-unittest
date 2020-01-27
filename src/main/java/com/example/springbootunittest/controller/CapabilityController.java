package com.example.springbootunittest.controller;

import com.example.springbootunittest.assembler.CapabilityResourceAssembler;
import com.example.springbootunittest.model.Capability;
import com.example.springbootunittest.service.CapabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/v1/capability")
@RequiredArgsConstructor
@CrossOrigin
public class CapabilityController {

    private final CapabilityService capabilityService;
    private final CapabilityResourceAssembler capabilityResourceAssembler;

    @GetMapping(value = "/list")
    public CollectionModel<EntityModel<Capability>> getAllCapabilities() {
//        List<EntityModel<Capability>> capabilities = capabilityService.listCapabilities().stream()
//                .map(capability -> new EntityModel<>(capability,
//                        linkTo(methodOn(CapabilityController.class).getCapabilityById(capability.getId())).withRel("getThisCapability"),
//                        linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
//                )).collect(Collectors.toList());
        return new CollectionModel<>(capabilityService.listCapabilities().stream()
                .map(capability -> capabilityResourceAssembler.toModel(capability)
                        .add(new Link("localhost:8099/api/v1/capability").withRel("createCapability")))
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/list/noembedded")
    public List<Capability> getAllCapabilitiesWithoutEmbedded() {
        List<Capability> capabilityList = capabilityService.listCapabilities();
        for (Capability capability : capabilityList) {
            capability.add(linkTo(methodOn(CapabilityController.class).getCapabilityById(capability.getId())).withRel("getThisCapability"));
            capability.add(linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
        }
        return capabilityList;
//        return new CollectionModel<>(capabilityService.listCapabilities().stream()
//                .map(capability -> capabilityResourceAssembler.toModel(capability)
//                        .add(new Link("localhost:8099/api/v1/capability").withRel("createCapability")))
//                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public EntityModel<Capability> getCapabilityById(@PathVariable String id) {
//        return new EntityModel<>(capabilityService.getCapability(id),
//                linkTo(methodOn(CapabilityController.class).getCapabilityById(id)).withRel("getThisCapability")
//        );
        return capabilityResourceAssembler.toModel(capabilityService.getCapability(id));
    }

    @PostMapping
    public EntityModel<Capability> createCapability(@RequestBody Capability capability) {
//        Capability newCapability = capabilityService.createCapability(capability);
//        return new EntityModel<>(newCapability,
//                linkTo(methodOn(CapabilityController.class).getCapabilityById(capability.getId())).withRel("getThisCapability"),
//                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
//        );
        return capabilityResourceAssembler.toModel(capabilityService.createCapability(capability));
    }

    @PutMapping
    public EntityModel<Capability> updateCapability(@RequestBody Capability capability) {
//        Capability updatedCapability = capabilityService.updateCapability(capability);
//        return new EntityModel<>(updatedCapability,
//                linkTo(methodOn(CapabilityController.class).getCapabilityById(capability.getId())).withRel("getThisCapability"),
//                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
//        );
        return capabilityResourceAssembler.toModel(capabilityService.updateCapability(capability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapability(@PathVariable String id) {
        capabilityService.deleteCapability(id);
        return ResponseEntity.ok().build();
    }
}
