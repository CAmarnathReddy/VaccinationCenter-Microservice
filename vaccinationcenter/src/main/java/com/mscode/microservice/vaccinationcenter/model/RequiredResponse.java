package com.mscode.microservice.vaccinationcenter.model;

import java.util.List;

import com.mscode.microservice.vaccinationcenter.entity.VaccnationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequiredResponse {
	
	private VaccnationCenter center;
	
	private List<Citizen> citizens;

	public VaccnationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccnationCenter center) {
		this.center = center;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}


	
	

}
