package new_onetomany_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import new_onetomany_uni.dto.Company;
import new_onetomany_uni.dto.Employee;

public class CompanyDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveCompany(Company company) {
		List<Employee> list = company.getEmployees();
		entityTransaction.begin();
		for (Employee employee : list) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();

	}

	public void deleteCompany(int id) {
		Company company = entityManager.find(Company.class, id);

		entityTransaction.begin();
		entityManager.remove(company);
		entityTransaction.commit();
		System.out.println("Company deleted successfully ! ");
	}

	public void deleteEmployee(int id) {
		// Company company = entityManager.find(Company.class, id);
		Employee employee = entityManager.find(Employee.class, id);

		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee deleted successfully ! ");

		}
	}

	public void findCompanyById(int id) {
		Company company = entityManager.find(Company.class, id);
		System.out.println(company);

	}

	public void addEmployee(Employee employee, int id) {

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.err.println("Add Employee successfully ! ");
	}

	public void updateCompanyInfo(int id, Company company) {
		Company dbCompany = entityManager.find(Company.class, id);
		if (dbCompany != null) {
			company.setId(id);
			// companysetEmployees(dbCompany.getList());
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();

		} else {
			System.out.println("id not found ");
		}
	}

	public void updateBoth(int id, Company company) {
		Company dbCompany = entityManager.find(Company.class, id);
		if (dbCompany != null) {
			company.setId(id);
			for (int i = 0; i < dbCompany.getEmployees().size(); i++) {
				company.getEmployees().get(i).setId(dbCompany.getEmployees().get(i).getId());
			}
			entityTransaction.begin();
			List<Employee> employees = company.getEmployees();
			for (Employee employee : employees) {
				entityManager.merge(company);
			}
		}
	}

	public void addMultipleEmployee(Employee employee) {

	}

}
