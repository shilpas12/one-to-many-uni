package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Bus;
import com.ty.dto.Organization;

public class TestSaveOrganization {

	public static void main(String[] args) {

		List<Bus> buslist = new ArrayList<Bus>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bus bus = new Bus();
		bus.setCapacity(28);
		bus.setType("sleeper");
		buslist.add(bus);

		Bus bus1 = new Bus();
		bus1.setCapacity(24);
		bus1.setType("Express");
		buslist.add(bus1);
		
		Bus bus2 = new Bus();
		bus2.setCapacity(20);
		bus2.setType("AC");
		buslist.add(bus2);

		Organization org = new Organization();
		org.setName("SRS");
		org.setAddress("karnataka");
		org.setBus(buslist);

		entityTransaction.begin();
		entityManager.persist(org);
		entityManager.persist(bus);
		entityManager.persist(bus1);
		entityManager.persist(bus2);

		entityTransaction.commit();
		System.out.print("-------DATA STORED-------");

	}

}
