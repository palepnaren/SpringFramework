package com.naren.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("dataDao")
public class DataDAO{
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);// for getting the values of named parameters to place holders
	}
	
	public List<DataTable> getDataTables(){
		
//		try {
//			DataSource dataSource = jdbc.getDataSource();
//			Connection connection = dataSource.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return jdbc.query("select * from data", new DataTableRowMapper());
		
	}
	
	@Transactional
	public int[] create(List<DataTable> table){
		
		SqlParameterSource[] createBatch = SqlParameterSourceUtils.createBatch(table.toArray());
		
		return jdbc.batchUpdate("insert into data values (NULL, :gender, :name, :fave_color)", createBatch);
	}
	
	public boolean create(DataTable table){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(table);
		
		return jdbc.update("insert into data values (NULL, :gender, :name, :fave_color)", params) == 1;
	}
	
	public boolean delete(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);//only one value so using constructor.
		
	  return jdbc.update("delete from data where id = :id", params) == 1;
	}
	
	public DataTable getDataTable(int id){
			
	    MapSqlParameterSource source = new MapSqlParameterSource();
	    source.addValue("id", id);
			
			return jdbc.queryForObject("select * from data where id = :id",source, new DataTableRowMapper());
			
		}

}
