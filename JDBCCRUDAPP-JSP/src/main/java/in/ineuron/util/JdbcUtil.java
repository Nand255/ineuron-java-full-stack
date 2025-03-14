package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	// private constructor is created, so object of JdbcUtil is not created
	private JdbcUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException{
		
		return physicalConnection();
	}


	private static Connection logicalConnection() throws SQLException {
		String fileLoc = "C:\\Users\\Asus\\eclipse-workspace\\JDBCCRUDAPP\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		HikariConfig config = new HikariConfig(fileLoc);
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
	}


	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "C:\\Users\\Asus\\eclipse-workspace\\JDBCCRUDAPP\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		properties.load(fis);

		String url = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
//	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
//		// 6.close the resources used
//				if(resultSet != null) {
//					resultSet.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//	}
}
