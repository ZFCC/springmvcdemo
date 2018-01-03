package org.andy.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface GenericDao<T,PK extends Serializable> {

	 T getById(PK id);  
	  
	 List<T> findAll();  
	  
	 PK save(T entity);
 
}
