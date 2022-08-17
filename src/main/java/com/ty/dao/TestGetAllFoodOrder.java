package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;

public class TestGetAllFoodOrder {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();

		FoodOrder order = entityManager.find(FoodOrder.class, 1);

		System.out.println( order.getId());
		System.out.println(order.getCustomerName());
		System.out.println(order.getAddress());
		System.out.println( order.getPhone());

		List<Item> ls = order.getItem();
		if (!ls.isEmpty()) {
			for (Item s : ls) {
				System.out.println(  s.getId());
				System.out.println( s.getName());
				System.out.println( s.getCost());
				System.out.println(s.getQuantity());
				System.out.println("-----------------------------------");
			}
		}
	}

}
