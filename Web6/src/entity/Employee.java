package entity;

/**
 * 实体类
 * 	实体类与表对应：表有哪些列，对应的实体类就会有哪些列，并且类型要匹配。
 * 	另外，属性需要有对应的get/set方法。
 * @author 木石前盟Cam
 *
 */
public class Employee {
	private int id;
	private String name;
	private double salary;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
