package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDAO departmentdao = DAOFactory.createDepartmentDao();
		
		System.out.println("\n---------- TEST 1: department Insert -----------");
		Department dep = new Department(null,"Music");
		departmentdao.insert(dep);
		System.out.println("Inserido! Novo id: " + dep.getId());
		
		System.out.println("\n---------- TEST 2: department FindById -----------");
		Department dep2 = departmentdao.findById(1);
		System.out.println(dep2);
		
		System.out.println("\n---------- TEST 3: department Update -----------");
		dep = departmentdao.findById(6);
		dep.setName("Film");
		departmentdao.update(dep);
		System.out.println("Update completado");
		
		System.out.println("\n---------- TEST 4: department Delete -----------");
		departmentdao.deleteById(7);
		System.out.println("Deletado");
		
		System.out.println("\n---------- TEST 5: department FindAll -----------");
		List<Department> lista = new ArrayList<>();
		lista = departmentdao.findAll();
		for(Department o : lista) {
			System.out.println(o);
		}
	}

}
