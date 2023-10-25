package new_onetomany_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import new_onetomany_uni.dto.Company;

public class Caching {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company company = entityManager.find(Company.class, 102);
		System.out.println(company);

		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		Company company2 = entityManager2.find(Company.class, 102);
		System.out.println(company2);

	}
}
