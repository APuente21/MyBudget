package com.budget.db;

import javax.sql.DataSource;

public interface ConfigDB {

	public DataSource getDataSource(String name);
	
	public String GetDataSourceDetails();
}
