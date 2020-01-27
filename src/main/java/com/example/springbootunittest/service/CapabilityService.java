package com.example.springbootunittest.service;

import com.example.springbootunittest.exceptions.EmployeeException;
import com.example.springbootunittest.model.Capability;
import com.example.springbootunittest.repository.CapabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CapabilityService {

    private final CapabilityRepository capabilityRepository;

    public List<Capability> listCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability getCapability(String capabilityId) {
        return capabilityRepository.findById(capabilityId)
                .orElseThrow(() -> new EmployeeException("Capability with ID: "+capabilityId+" Not found"));
    }

    public Capability createCapability(Capability capability) {
        return capabilityRepository.insert(capability);
    }

    public Capability updateCapability(Capability capability) {
        return capabilityRepository.findById(capability.getId())
                .map(capability1 -> capabilityRepository.save(capability))
                .orElseGet(() -> capabilityRepository.insert(capability));
    }

    public void deleteCapability(String capabilityId) {
        capabilityRepository.delete(
                capabilityRepository.findById(capabilityId)
                        .orElseThrow(() -> new EmployeeException("Capability with ID: "+capabilityId+" Not found")));
    }

}
