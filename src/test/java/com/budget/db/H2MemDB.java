package com.budget.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;
import org.h2.tools.RunScript;
import org.springframework.stereotype.Component;

public class H2MemDB {

	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private static RunScript runscript;
    private static Connection connection = getDBConnection();
    
    public H2MemDB() {
        try {
        	ClassLoader classLoader = getClass().getClassLoader();
        	File schema = new File(classLoader.getResource("META-INF/sql/h2schema.sql").getFile());
        	File testScript = new File(classLoader.getResource("META-INF/sql/test-data.sql").getFile());
        	RunScript.execute(connection, new FileReader(schema));
        	RunScript.execute(connection, new FileReader(testScript));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
    	
    }
    

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

