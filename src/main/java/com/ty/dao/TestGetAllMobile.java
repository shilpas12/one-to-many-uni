package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestGetAllMobile {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 1);

		System.out.println("Mobile id : "+ mobile.getId());
		System.out.println("Mobile Name: "+mobile.getName());
		System.out.println("Mobile cost : "+ mobile.getCost());
		
		List<Sim>ls=mobile.getSim();
		if(!ls.isEmpty()) {
			for(Sim s:ls ) {
				System.out.println("Sim id: "+s.getId());
				System.out.println("Sim Imrc: "+s.getImrc());
				System.out.println("Sim provider: "+s.getProvider());
				System.out.println("-----------------------------------");
			}
		}
	}

}
