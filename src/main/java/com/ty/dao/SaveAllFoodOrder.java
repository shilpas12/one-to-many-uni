package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;

public class SaveAllFoodOrder {

	public static void main(String[] args) {
		List<Item> listItem = new ArrayList<Item>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item it = new Item();
		it.setName("north meal");
		it.setCost(98);
		it.setQuantity("full");
		listItem.add(it);

		Item it1 = new Item();
		it1.setName("south meal");
		it1.setCost(120);
		it1.setQuantity("full");
		listItem.add(it1);

		Item it2 = new Item();
		it2.setName("Non Tan meal");
		it2.setCost(356);
		it2.setQuantity("half");
		listItem.add(it2);

		FoodOrder order = new FoodOrder();
		order.setCustomerName("shyam");
		order.setAddress(" ashok nagar mandya");
		order.setPhone(78968l);
		order.setItem(listItem);

		entityTransaction.begin();
		entityManager.persist(it);
		entityManager.persist(it1);
		entityManager.persist(it2);
		entityManager.persist(listItem);

		entityTransaction.commit();
		System.out.print("-------DATA STORED-------");

	}

}
