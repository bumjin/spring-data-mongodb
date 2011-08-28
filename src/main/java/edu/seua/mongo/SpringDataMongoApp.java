
package edu.seua.mongo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;

/**
 * Java Spring Data & MongoDB Example
 * 
 */
public class SpringDataMongoApp {

    public static void main(String[] args) {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("edu/seua/mongo/mongo-config.xml");

	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	Employee employee = new Employee("100", "firstName", "lastName", 23);

	// save
	mongoOperation.save(employee, "employees" );

	// find
	Employee savedEmployee = mongoOperation.findOne(new Query(Criteria.where(
		"id").is("100")), Employee.class, "employees" );

	System.out.println("Saved Employee: " + savedEmployee);

	// update
	mongoOperation.updateFirst(new Query(Criteria.where(
		"firstname").is("firstName")), Update.update("lastname",
		"new lastName"), "employees" );

	// find
	Employee updatedEmployee = mongoOperation.findOne(new Query(
		Criteria.where("id").is("100")), Employee.class, "employees" );

	System.out.println("Updated Employee: " + updatedEmployee);

	// delete
	mongoOperation.remove(new Query(Criteria.where("id").is(
		"100")), "employees" );

	/*// List
	List<Employee> listEmployee = mongoOperation.getCollection("employees" );
	System.out.println("size of employees = " + listEmployee.size());*/

    }
}