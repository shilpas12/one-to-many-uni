package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.Bus;
import com.ty.dto.Organization;

public class TestGetAllOrg {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();

		Organization org = entityManager.find(Organization.class, 2);
		System.out.println("Organization id : " + org.getId());
		System.out.println("Organization Name : " + org.getName());
		System.out.println("Organization id : " + org.getAddress());
		
		List<Bus>ls=org.getBus();
		
		if(!ls.isEmpty()) {
			for(Bus b: ls) {
				System.out.println(b.getId());
				System.out.println(b.getCapacity());
				System.out.println(b.getType());
				System.out.println("------------------------");
			}
		}

	}

}
