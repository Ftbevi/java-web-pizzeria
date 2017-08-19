package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity(name="deliveryman")
@PrimaryKeyJoinColumn(name="cod_employee")
public class Deliveryman extends Employee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_deliveryman")
	private Long code;

	@Column(name="cellphone", nullable=false)
	private String cellphone;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
