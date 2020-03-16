package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConn {

	public static void main(String[] args) {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "sa";

			String password = "1234";

			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=testdb";

			Connection con = DriverManager.getConnection(url, userName, password);

			Statement s1 = con.createStatement();

			ResultSet rs = s1.executeQuery("select Emp_ID, Emp_Name, Emp_Salary from Employee_Details where Emp_Salary <= 60000;");

			while (rs.next()) {

				String id = rs.getString(1);

				String name = rs.getString(2);
				
				String salary= rs.getString(3);

				System.out.println("Employee ID = " + id +", Employee Name = "+name+", Salary = "+salary );

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}