package com.naren.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DataTableRowMapper implements RowMapper<DataTable> {

	public DataTable mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataTable data = new DataTable();
		
		data.setId(rs.getInt("id"));
		data.setGender(rs.getString("gender"));
		data.setName(rs.getString("name"));
		data.setFave_color(rs.getString("fave_color"));
		
		return data;
	}

}
