package dao;

import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	
	   @Autowired
	   private JdbcTemplate jdbcTemplate;
	   @Autowired
	   DataSource dataSource;

		// Find all customers, thanks Java 8, you can create a custom RowMapper like this :
	    public List<Customer> findAll() {

	    	List<Customer> results = jdbcTemplate.query("SELECT * FROM customer", new BeanPropertyRowMapper(Customer.class));

	    	return results;
	    	
	  /*      List<Customer> result = jdbcTemplate.query(
	                "SELECT id, firstname,lastname, email FROM customer",
	                (rs, rowNum) -> new Customer(rs.getInt("id"),
	                        rs.getString("firstname"),rs.getString("lastname"), rs.getString("email"));
	        return result;*/
}
}






