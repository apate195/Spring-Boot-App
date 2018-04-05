package controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.RegisterDao;
import entity.Customer;
import entity.Register;

@RestController
@RequestMapping("customer")
public class CustomerController {

	
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDao;
	private RegisterDao reg;
	
	@RequestMapping("/list")
	
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerDao.findAll();
			//Gson gson = new Gson();
			//String name = gson.toJson(theCustomers);
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		System.out.println(theCustomers);
		//return "<html><h1>hi</h1><body>${customers}</body></html>";
		return " "+theCustomers;
	}
	@RequestMapping("/add")
	public String insert(Model themodel){
		String s=reg.add();
		themodel.addAttribute("data",s);
		System.out.println(s);
		return "inserted successfully";
	}
}


