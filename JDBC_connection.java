package task_sql;
import java.sql.*;

public class JDBC_connection {

	public static void main(String[] args) {

    // Step 1: JDBC driver name and database URL
    String DB_URL = "jdbc:mysql://localhost:3306";

    // Step 2 : Database credentials
    String USER = "root"; 
    String PASS = "root"; 

    // Step 3 : Establish the Connections
    try {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
		//Step 4 : Perform Operation
		//Create the statement
		String createDB = "create database JDBC_TASK";
		String useDB = "use JDBC_TASK";
		String createTable = "create table JDBC_emp (empcode INT, empname varchar(20), empage INT, esalary INT)";
		String insertValue = "INSERT INTO JDBC_emp (empcode, empname, empage, esalary) VALUES " +
                "(101, 'Jenny', 25, 10000), " +
                "(102, 'Jacky', 30, 20000), " +
                "(103, 'Joe', 20, 40000), " +
                "(104, 'John', 40, 80000), " +
                "(105, 'Shameer', 25, 90000)";
		String select = "SELECT * FROM JDBC_emp";
		
	// Step 5: Execute the Statements
		Statement emp = conn.createStatement();
		emp.execute(createDB);
		emp.execute(useDB);
		emp.execute(createTable);
		emp.executeUpdate(insertValue);
		
		ResultSet result = emp.executeQuery(select);
		
		while(result.next()) {
			System.out.println(result.getInt("empcode")+ "--" +result.getString("empname") + "--" 
		+result.getInt("empage") + "--" +result.getInt("esalary"));
		}
		
		// Step 6 : Close the connection
		
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    

        
	}
}
