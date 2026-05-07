package com.group8.assetflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group8.assetflow.model.DigitalVendor;

@Repository
public interface DigitalVendorRepository extends JpaRepository<DigitalVendor, Long> {
	
}