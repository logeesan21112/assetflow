package com.group8.assetflow.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group8.assetflow.model.DigitalVendor;
import com.group8.assetflow.repository.DigitalVendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DigitalVendorService {

    private final DigitalVendorRepository digitalVendorRepository;

    public DigitalVendorService(DigitalVendorRepository digitalVendorRepository) {
        this.digitalVendorRepository = digitalVendorRepository;
    }

    public List<DigitalVendor> getAllVendors() {
        return digitalVendorRepository.findAll();
    }

    public Optional<DigitalVendor> findById(Long id) {
        return digitalVendorRepository.findById(id);
    }

    @Transactional
    public DigitalVendor save(DigitalVendor digitalVendor) {
        return digitalVendorRepository.save(digitalVendor);
    }

    @Transactional
    public void deleteById(Long id) {
        digitalVendorRepository.deleteById(id);
    }
}