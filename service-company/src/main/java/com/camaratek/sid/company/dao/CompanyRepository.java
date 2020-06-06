package com.camaratek.sid.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camaratek.sid.company.models.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
