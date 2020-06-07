package com.camaratek.sid.company;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.camaratek.sid.company.dao.CompanyRepository;
import com.camaratek.sid.company.models.Company;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start( CompanyRepository  companyRepository) {
		return arg -> {
			Stream.of("A", "B", "C", "D")
				  .forEach(cm -> companyRepository.save(new Company(null, cm, 100 + Math.random()*900)));
			companyRepository.findAll().forEach( System.out::println );
		};
			
	}

}
