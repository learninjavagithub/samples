package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1, "Scott");
		Serialization.serializeObject(emp1);
		
		Employee emp2 = (Employee) Serialization.deserializeObject();
		
		System.out.println("Emp Id : " + emp1.getEmpId() + " Class Name : " + emp1.className + " Emp Name : " + emp1.getEmpName() + " Salary : " + emp1.salary);
		System.out.println("Emp Id : " + emp2.getEmpId() + " Class Name : " + emp2.className + " Emp Name : " + emp2.getEmpName() + " Salary : " + emp2.salary);
	}

	public static void serializeObject(Object obj) {
		
		try ( ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C:/Praveen/emp.ser")) ) {
			
			oos.writeObject(obj);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserializeObject() {
		
		Object result = null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:/Praveen/emp.ser"))) {
			
			result = ois.readObject();
			
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
class Person implements Serializable {
	

	private static final long serialVersionUID = -3647412319629660477L;
	
	String name = "Person";
	String className = "PersonClass";
}

class Employee extends Person {

	private static final long serialVersionUID = 7196263935932272732L;

	String name = "Employee";
	//Remove transient to allow salary to get serialized as well
	transient int salary = 50000;
				
	private int empId;
	private String empName;
	
	public Employee(int empId, String empName) {
		
		this.empId = empId;
		this.setEmpName(empName);
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
}