package application;

import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1,"Books");
		System.out.println(obj);
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);
		System.out.println(seller);
		
		SellerDAO sellerdao = DAOFactory.createSellerDao();
		System.out.println("\n---------- TEST 1: seller FindById -----------");
		Seller seller2 = sellerdao.findById(3);
		System.out.println(seller2);
		
		System.out.println("\n---------- TEST 2: seller FindByDepartment -----------");
		Department department = new Department(2,null);
		List<Seller> lista = sellerdao.findByDepartment(department);
		for(Seller o : lista) {
			System.out.println(o);
		}
		
		System.out.println("\n---------- TEST 3: seller FindAll -----------");
		lista = sellerdao.findAll();
		for(Seller o : lista) {
			System.out.println(o);
		}
		
		System.out.println("\n---------- TEST 4: seller Insert -----------");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, new Department(2,null));
		sellerdao.insert(newSeller);
		System.out.println("Inserido! Novo id: " + newSeller.getId());
	}

}
