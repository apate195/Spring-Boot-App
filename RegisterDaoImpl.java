package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;

import entity.Customer;
import entity.Register;

public class RegisterDaoImpl implements RegisterDao {

	
	@Autowired
	   private JdbcTemplate jdbcTemplate;
	   @Autowired
	   DataSource dataSource;
	  public String add(){
		//  String name = register.getFirstname();
		 /* String lname = register.getLastname();
		  String email = register.getEmail();
		  String phone = register.getPhone();*/
		  String sql = "insert into register values ('jay','ads','adfsf','1515')";
		 String s = jdbcTemplate.batchUpdate(sql).toString();
		  return s;
	  }
	
	}


