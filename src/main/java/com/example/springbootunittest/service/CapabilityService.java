package com.example.springbootunittest.service;

import com.example.springbootunittest.model.Capability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CapabilityService {

//    private final CapabilityRepository capabilityRepository;

    public List<Capability> listCapabilities() {
//        Capability capability = getCapability();
        return Arrays.asList(getCapability());
//        return capabilityRepository.findAll();
    }

    private Capability getCapability() {
        return Capability.builder()
                    .id("sample")
                    .numOfAvailableDevelopers(10)
                    .numOfDevelopers(25)
                    .techStack("Java")
                    .build();
    }

    public Capability getCapability(String capabilityId) {
        return getCapability();
//        return capabilityRepository.findById(capabilityId)
//                .orElseThrow(() -> new EmployeeException("Capability with ID: "+capabilityId+" Not found"));
    }

    public Capability createCapability(Capability capability) {
        return capability;
        // return capabilityRepository.insert(capability);
    }

    public Capability updateCapability(Capability capability) {
        return capability;
//        return capabilityRepository.findById(capability.getId())
//                .map(capability1 -> capabilityRepository.save(capability))
//                .orElseGet(() -> capabilityRepository.insert(capability));
    }

    public void deleteCapability(String capabilityId) {
        return;
//        capabilityRepository.delete(
//                capabilityRepository.findById(capabilityId)
//                        .orElseThrow(() -> new EmployeeException("Capability with ID: "+capabilityId+" Not found")));
    }

}
