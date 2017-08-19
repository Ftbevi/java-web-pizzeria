package br.edu.ifce.utils;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifce.model.Client;
import br.edu.ifce.model.Deliveryman;
import br.edu.ifce.model.Ingredient;
import br.edu.ifce.model.Menu;
import br.edu.ifce.model.Neighborhood;
import br.edu.ifce.model.Order;
import br.edu.ifce.model.Pizza;
import br.edu.ifce.model.Waitress;

public class PersistindoDados {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
//		Inserting Client
		Client client = new Client();
		client.setName("Thiago Beviláqua");
		client.setPhone("(34) 1234-5678");
		client.setAddress("Rua Teofilo Beviláqua");
		
		Client client2 = new Client();
		client2.setName("Manoel Soaress");
		client2.setPhone("(85) 1414-5680");
		client2.setAddress("Rua dos guararapes");
		
		manager.persist(client);
		manager.persist(client2);
		
//		Inserting Neighborhood
		Neighborhood neighborhood = new Neighborhood();
		neighborhood.setName("Alvaro Weyne");
		neighborhood.setTimeWaiting(15);
		
		Neighborhood neighborhood2 = new Neighborhood();
		neighborhood2.setName("Good Garden");
		neighborhood2.setTimeWaiting(20);
		
		manager.persist(neighborhood);
		manager.persist(neighborhood2);
		
//		Inserting Employee
		Waitress waitress = new Waitress();
		waitress.setName("Virginia Nunes");
		waitress.setAddress("Ruas do Mondubim");
		waitress.setPhone("(85) 3232-7799");
		
		Deliveryman deliveryman = new Deliveryman();
		deliveryman.setName("Cornelli Jurnior");
		deliveryman.setAddress("Beira Mar");
		deliveryman.setPhone("(85) 4544-0055");
		deliveryman.setCellphone("(85) 4544-0055");
		
		manager.persist(waitress);
		manager.persist(deliveryman);
		
//		Inserting Ingredients
		Ingredient ingredient = new Ingredient();
		ingredient.setName("Molho de Tomate");
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setName("Oregano");
		
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setName("Queijo Mussarela");
		
		Ingredient ingredient4 = new Ingredient();
		ingredient4.setName("Calabresa");
		
		manager.persist(ingredient);
		manager.persist(ingredient2);
		manager.persist(ingredient3);
		manager.persist(ingredient4);

//		Inserting Pizza
		Pizza pizza = new Pizza();
		pizza.setName("Pizza Tomate");
		pizza.getIngredients().add(ingredient);
		pizza.getIngredients().add(ingredient2);
		
		Pizza pizza2 = new Pizza();
		pizza2.setName("Pizza Mussarela");
		pizza2.getIngredients().add(ingredient3);
		pizza2.getIngredients().add(ingredient4);
		
		manager.persist(pizza);
		manager.persist(pizza2);
		
//		Inserting Menu
		Menu menu = new Menu();
		menu.setName("Seção de Pizza");
		menu.getPizzas().add(pizza);
		menu.getPizzas().add(pizza2);
		
		manager.persist(menu);
		
//		Inserting to_order
		Order order = new Order();
		order.setDataEmissao(new Date());
		order.setClient(client);
		order.setWaitress(waitress);
		order.setDeliveryman(deliveryman);
		order.setNeighborhood(neighborhood2);
		order.getPizzas().add(pizza2);
		order.getPizzas().add(pizza);
		
		manager.persist(order);
		
		transaction.commit();
		manager.close();
		JpaUtil.close();
	}

}
