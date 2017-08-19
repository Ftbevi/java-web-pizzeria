package br.edu.ifce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="to_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_order")
	private Long codeOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_emissao", nullable=false)
	private Date dataEmissao;
	
	@ManyToOne
	@JoinColumn(name="cod_client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="cod_neighborhood", nullable=false)
	private Neighborhood neighborhood;
	
	@ManyToOne
	@JoinColumn(name="cod_waitress", nullable=false)
	private Waitress waitress;
	
	@ManyToOne
	@JoinColumn(name="cod_deliveryman", nullable=false)
	private Deliveryman deliveryman;
	
	@OneToMany
	private List<Pizza> pizzas = new ArrayList<>();
	
	public Long getCodeOrder() {
		return codeOrder;
	}

	public void setCodeOrder(Long codeOrder) {
		this.codeOrder = codeOrder;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Waitress getWaitress() {
		return waitress;
	}

	public void setWaitress(Waitress waitress) {
		this.waitress = waitress;
	}

	public Deliveryman getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(Deliveryman deliveryman) {
		this.deliveryman = deliveryman;
	}
	
}
