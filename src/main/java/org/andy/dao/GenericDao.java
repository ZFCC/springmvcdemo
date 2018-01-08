package org.andy.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface GenericDao<T,PK extends Serializable> {

	 T getById(PK id);  
	  
	 List<T> findAll();  
	  
	 PK save(T entity);
 
	 PK delete(PK id);
	 
	 int updateById(T entity);
	 
	 //批量更新
	 int[] batchSave(List<T> users);
	 
	 //批量删除
	 int[] batchDelete(List<PK> id);
}
