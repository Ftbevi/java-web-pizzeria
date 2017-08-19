package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="neighborhood")
public class Neighborhood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_neighborhood")
	private Long code;
	
	@Column(name="name_neighborhood", nullable=false)
	private String name;
	
	@Column(name="time_waiting", nullable=false)
	private Integer timeWaiting;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimeWaiting() {
		return timeWaiting;
	}

	public void setTimeWaiting(Integer timeWaiting) {
		this.timeWaiting = timeWaiting;
	}
	
}
