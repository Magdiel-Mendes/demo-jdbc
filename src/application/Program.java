package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityExceptioin;
public class Program {
	 
	public static void main(String[] args) {
 
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			// todas as operações ficaram pendentes esperando confirmação
			conn.setAutoCommit(false);
			st = conn.createStatement();
			
			
			int rows  = st.executeUpdate("UPDATE seller SET BaseSalary = 20000 WHERE DepartmentId = 1");
//			int x = 1;
//			if(x < 2) {
//				throw new SQLException("Fake error!");
//			}
			int rows2  = st.executeUpdate("UPDATE seller SET BaseSalary = 40000 WHERE DepartmentId = 2");
			conn.commit();
			System.out.println("rows " + rows);
			System.out.println("rows " + rows2);
			
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("transaction rolled back! Caused: " + e.getMessage());
			} catch (SQLException el) {
				throw new DbException("Error trying to rollback! Caused by: " + el.getMessage());
			}
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}