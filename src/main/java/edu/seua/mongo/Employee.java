
package edu.seua.mongo;

public class Employee {

    private String id;
    private String firstname;
    private String lastname;
    private int age;

    public Employee() {
    }

    public Employee(String id, String firstname, String lastname, int age) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    @Override
    public String toString() {
	return "Employee [age=" + age + ", firstname=" + firstname + ", id="
		+ id + ", lastname=" + lastname + "]";
    }

}
