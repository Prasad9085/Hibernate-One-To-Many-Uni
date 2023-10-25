package new_onetomany_uni.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.Id;

import new_onetomany_uni.dao.CompanyDao;
import new_onetomany_uni.dto.Company;
import new_onetomany_uni.dto.Employee;

public class MainController {
	public static void main(String[] args) {
		Company company = new Company();
		Employee employee = new Employee();
		CompanyDao companyDao = new CompanyDao();

		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"Enter the choice \n1. saveCompany \n2. deleteCompany\n3.deleteEmployeeById \n4.findCompanyById \n5.addEmployee\n6.updateCompany"
						+ "s\n7.addMultipleEmployee\n8.updateBoth");
		int choice = scanner.nextInt();
		ArrayList list = new ArrayList();
		switch (choice) {
		case 1: {
			Employee employee1 = new Employee();
			System.out.println("Enter the id ");
			employee1.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			employee1.setName(scanner.next());
			System.out.println("Enter the phone : ");
			employee1.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			employee1.setAddress(scanner.next());

			Employee employee2 = new Employee();
			System.out.println("Enter the id ");
			employee2.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			employee2.setName(scanner.next());
			System.out.println("Enter the phone : ");
			employee2.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			employee2.setAddress(scanner.next());

			Employee employee3 = new Employee();
			System.out.println("Enter the id ");
			employee3.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			employee3.setName(scanner.next());
			System.out.println("Enter the phone : ");
			employee3.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			employee3.setAddress(scanner.next());

			list.add(employee1);
			list.add(employee2);
			list.add(employee3);

			System.out.println("Enter the Company details ");
			System.out.println("Enter the id :  ");
			company.setId(scanner.nextInt());
			System.out.println("Enter the name ");
			company.setName(scanner.next());
			System.out.println("Enter the location : ");
			company.setLocation(scanner.next());
			System.out.println("Enter the GST number :  ");
			company.setGst(scanner.next());
			company.setEmployees(list);
			companyDao.saveCompany(company);

		}
			break;
		case 2: {
			System.out.println("Enter the id : ");
			int id = scanner.nextInt();
			companyDao.deleteCompany(id);

		}
			break;
		case 3: {
			System.out.println("Enter the id : ");
			int id = scanner.nextInt();
			companyDao.deleteEmployee(id);
		}
			break;
		case 4: {
			System.out.println("Enter the Company id : ");
			int id = scanner.nextInt();
			companyDao.findCompanyById(id);

		}
			break;
		case 5: {
			System.out.println("Enter the company id");
			int id = scanner.nextInt();

			System.out.println("Enter the employee details ");
			System.out.println("Enter the id ");
			employee.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			employee.setName(scanner.next());
			System.out.println("Enter the phone : ");
			employee.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			employee.setAddress(scanner.next());
			list.add(employee);

			company.setEmployees(list);

			companyDao.addEmployee(employee, id);

		}
			break;
		case 6: {
			System.out.println("Enter the company id :  ");
			int id = scanner.nextInt();
			System.out.println("Enter the Company name :");
			company.setName(scanner.next());
			System.out.println("Enter the Company location :");
			company.setLocation(scanner.next());
			System.out.println("Enter the Company GST :");
			company.setGst(scanner.next());
			company.setId(choice);
			company.setId(id);
			companyDao.updateCompanyInfo(id, company);
		}
			break;
		case 7: {
			System.out.println("Enter the how many employee will be add : ");
			int size = scanner.nextInt();
			System.out.println("Enter the company id : ");
			int id = scanner.nextInt();
			for (int i = 0; i < size; i++) {

				System.out.println("Enter the id ");
				employee.setId(scanner.nextInt());
				System.out.println("Enter the name : ");
				employee.setName(scanner.next());
				System.out.println("Enter the phone : ");
				employee.setPhone(scanner.nextLong());
				System.out.println("Enter the address : ");
				employee.setAddress(scanner.next());
				list.add(employee);
			}
			company.setEmployees(list);
			companyDao.addMultipleEmployee(employee);

		}
			break;
		case 8: {
			System.out.println("Enter the Company name : ");
			company.setName(scanner.next());
			System.out.println("Enter the Company location : ");
			company.setLocation(scanner.next());
			System.out.println("Enter the Company GST : ");
			company.setGst(scanner.next());
			System.out.println("Enter the name");
		}
			break;
		default:
			break;
		}

	}

}
