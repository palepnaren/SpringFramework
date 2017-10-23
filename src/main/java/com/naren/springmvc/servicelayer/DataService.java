package com.naren.springmvc.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naren.springmvc.dao.DataDAO;
import com.naren.springmvc.dao.DataTable;

@Service("dataService")
public class DataService {

	private DataDAO dao;
	
	@Autowired
	public void setDao(DataDAO dao) {
		this.dao = dao;
	}

	public List<DataTable> getCurrent(){
		return dao.getDataTables();
	}
	
	public boolean save(DataTable data){
		
		return dao.create(data);
	}
}
