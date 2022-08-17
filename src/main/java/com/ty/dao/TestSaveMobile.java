package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestSaveMobile {

	public static void main(String[] args) {

		List<Sim> listSim = new ArrayList<Sim>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Sim sim = new Sim();
		sim.setProvider("BSNL");
		sim.setImrc(899);
		listSim.add(sim);

		Sim sim1 = new Sim();
		sim1.setProvider("AIRTEL");
		sim1.setImrc(7687);
		listSim.add(sim1);

		Mobile mobile = new Mobile();
		mobile.setName("OnePlus");
		mobile.setCost(420000);

		mobile.setSim(listSim);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);

		entityTransaction.commit();
		System.out.print("-------DATA STORED-------");

	}

}
