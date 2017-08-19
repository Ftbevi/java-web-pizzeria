package br.edu.ifce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_pizza")
	private Long code;
	
	@Column(name="name_pizza", nullable=false)
	private String name;
		
	@ManyToMany
	@JoinTable(name="pizza_ingredients",
		joinColumns = @JoinColumn(name="cod_pizza"),
		inverseJoinColumns = @JoinColumn(name="cod_ingredients"))
	private Set<Ingredient> ingredients = new HashSet<>();

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

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
