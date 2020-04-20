package webBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public Connection con;
	public Statement stmt;
	
//return statement 	
	public Statement getStatement() throws ClassNotFoundException, SQLException{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String connection = "jdbc:mysql://10.126.85.150/televente_rec";
			String userName = "user_televente";
			String password = "test";
			Class.forName(driver);
			con = DriverManager.getConnection(connection, userName, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public void insertData(String query) throws ClassNotFoundException, SQLException{
		Statement sta = getStatement();
		sta.executeUpdate(query);
	}
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException{
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}
	
	public void updateData(String query) throws ClassNotFoundException, SQLException{
		getStatement().executeUpdate(query);
		
	}
	
	
}