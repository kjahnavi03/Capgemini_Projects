package project;

import java.util.Scanner;
class Employee{
	private int id;
	private String name;
	private String department;
	private double salary;
	
	public Employee(int id,String name,String department,double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return this.id;
	}
	public String getDepartment() {
		return this.department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary(){
		return this.salary;
	}
	@Override
	public String toString() {
		//Employee[ID=101, Name=Slice, Department=IT, Salary=50000]
		return this.getClass().getName()+"[ID="+this.id+", Name="+this.name+", Department="+this.department+", Salary="+this.salary+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return false;
		Employee e = (Employee)obj;
		return this.id==e.id;
	}
	public int hashCode() {
		return this.id*this.name.length();
	}
}

public class Employee_Management_System  {
	private Employee[] employee = new Employee[20];
	private int maxLen = 20;
	private static int count;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Employee_Management_System  e1 = new Employee_Management_System ();
//		e1.addEmployee();
//		e1.displayEmployee();
//		e1.updateEmployee();
//		e1.addEmployee();
//		e1.displayEmployee();
//		e1.deleteEmployee();
//		e1.displayEmployee();
//		e1.addEmployee();
//		e1.searchEmployee();
		System.out.println("Welcome to Employee Management System\r\n"
				+ "\r\n"
				+ "1.Add Employee\r\n"
				+ "2.Display All Employees\r\n"
				+ "3.Update Employee\r\n"
				+ "4.Delete Employee\r\n"
				+ "5.Search Employee by ID\r\n"
				+ "6.Count Employees by Department\r\n"
				+ "7.Exit");
		boolean condition = true;
		while(condition) {
			System.out.print("Choose an option: ");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				e1.addEmployee();
				System.out.print("Current employees: ");
				e1.displayEmployee();
				break;
			case 2:
				e1.displayEmployee();
				break;
			case 3:
				e1.updateEmployee();
				break;
			case 4:
				e1.deleteEmployee();
				break;
			case 5:
				e1.searchEmployee();
				break;
			case 6:
				e1.countByDepartment();
				break;
			case 7:
				condition = false;
			default:
				System.out.println("Progrmme phase over");
			}
		}
		sc.close();
	}
	private void addEmployee() {
		
		if(count==maxLen) {
			System.out.println("Array is full , plz delete an element to push further ");
			return;
		}
		System.out.print("Enter Employee ID:");
		int id = sc.nextInt();
		int checkIfAlreadyExist = searchIndex(id);
		if(checkIfAlreadyExist!=-1) {
			System.out.println("Employee with ID "+ id +" already exists! Cannot add duplicate.");
			return;
		}
		System.out.print("Enter Name:");
		String name = sc.next();
		System.out.print("Enter Department:");
		String department = sc.next();
		System.out.print("Enter Salary:");
		double salary = sc.nextDouble();
		
		Employee e = new Employee(id,name,department,salary);
		employee[count] = e;
		count++;
		System.out.println("Employee added successfully");
	}
	private void displayEmployee() {
		for(int i=0;i<count;i++) {
			System.out.println(employee[i].toString());
		}
	}
	public int searchIndex(int findId) {
		int index_return = -1;
		boolean found = false;
		int index = 0;
		while(index <count && !found ) {
			if(employee[index].getId()==findId) {
				index_return = index;
				found = true;
				break;
			}
			index = index + 1;
		}
		return index_return;
	}
	private void updateEmployee() {
		
		System.out.print("Enter an ID to Update: ");
		int idToSearch = sc.nextInt();
		boolean found = false;
		int index = 0;
		while(index <count && !found ) {
			if(employee[index].getId()==idToSearch) {
				System.out.print("Enter the name to update: ");
				String newName = sc.next();
				employee[index].setName(newName);
				System.out.print("Enter the department to update:");
				String newDepartment = sc.next();
				employee[index].setDepartment(newDepartment);
				System.out.print("Enter the salary to update: ");
				double newSalary = sc.nextDouble();
				employee[index].setSalary(newSalary);
				found = true;
			}
			index = index + 1;
		}
		if(found == false) {
			System.out.print("ID doesn't exist");
		}
		
	}
	private void deleteEmployee() {
		System.out.print("Enter an id to delete: ");
		int idDelete = sc.nextInt();
		int index = searchIndex(idDelete);
		if(index==-1) {
			System.out.println("id doesnot exist_"+index);
		}
		else {
			for(int i=index;i<count-1;i++) {
				employee[i] = employee[i+1];
			}
			count = count - 1;
			System.out.println(idDelete + "Successfully deleted");
			
		}
	}
	private void searchEmployee() {
		System.out.print("Enter the emplpyee id search :");
		int employeeSearch = sc.nextInt();
		int index = searchIndex(employeeSearch);
		if(index==-1) {
			System.out.println("This ID does not exist so serarch result is null ");
		}
		else {
			System.out.println("Found Employee: ");
			System.out.println(employee[index].toString());
		}
	}
	private void countByDepartment() {
		int times = 0;
		System.out.print("Enter the department to search: ");
		String depToSearch = sc.next();
		for(int i=0;i<count;i++) {
			if(employee[i].getDepartment().equals(depToSearch)) {
				times++;
			}
		}
		System.out.println(depToSearch + " present "+times + " times");
		//comment line added here 
		//comment line add no 3
	}
}