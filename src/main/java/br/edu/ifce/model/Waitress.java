package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="waitress")
@PrimaryKeyJoinColumn(name="cod_employee")
public class Waitress extends Employee{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_waitress")
	private Long code;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
}
