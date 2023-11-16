package com.jspiders.onetoonebi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column(unique = true, nullable = false)
	private long adharNumber;
	@OneToOne(mappedBy = "adharCard")
	private Person person;
	
	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", adharNumber=" + adharNumber + "]";
	}
	
	
}
