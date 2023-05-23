package com.mscode.microservice.vaccinationcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mscode.microservice.vaccinationcenter.entity.VaccnationCenter;
import com.mscode.microservice.vaccinationcenter.model.Citizen;
import com.mscode.microservice.vaccinationcenter.model.RequiredResponse;
import com.mscode.microservice.vaccinationcenter.repositories.VaacinationCenterRepository;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
	@Autowired
	private VaacinationCenterRepository vaacinationCenterRepository;
	
	@Autowired
	private RestTemplate restemp;
	
	@RequestMapping(path = "/addcenter")
	public ResponseEntity<VaccnationCenter> saveVaccinationCenter(@RequestBody VaccnationCenter vc) {
		if (null==vc) {
			System.out.println(" Bad requesu");
			return new ResponseEntity<VaccnationCenter>(vc, HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("test new for data---" + vc);
			VaccnationCenter svc = vaacinationCenterRepository.save(vc);
			return new ResponseEntity<VaccnationCenter>(svc, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getCenterData(@PathVariable Integer id){
		RequiredResponse rr = new RequiredResponse();
		VaccnationCenter vc = vaacinationCenterRepository.findById(id).get();
		rr.setCenter(vc);
		System.out.println("http://CITIZEN-SERVICE/citizen/id/"+id);
		List<Citizen> lc= restemp.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		rr.setCitizens(lc);
		
		
		return new ResponseEntity<RequiredResponse>(rr,HttpStatus.OK);
		
	}

}
