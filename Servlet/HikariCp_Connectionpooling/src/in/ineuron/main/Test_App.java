package in.ineuron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Test_App {
	public static void main(String[] args) {
		String configFile = "src\\in\\ineuron\\main\\db.properties";
		HikariConfig config = new HikariConfig(configFile);
		try (HikariDataSource dataSource = new HikariDataSource(config))  {
//			config.setDataSource(dataSource);
			
			//building connection
			// logic connection bought/brought from connection pool

//			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/student");
//			dataSource.setUsername("root");
//			dataSource.setPassword("2525");

			Connection connection = dataSource.getConnection();

			Statement stmt = connection.createStatement();

			ResultSet resultSet =  stmt.executeQuery("select s_id,s_name,c_id,assignment from student");

			System.out.println("s_id\ts_name\tc_id\tassignment");
			while (resultSet.next()) {
				int s_id = resultSet.getInt(1);
				String s_name = resultSet.getString(2);
				int c_id = resultSet.getInt(3);
				int assignment = resultSet.getInt(4);
				
				System.out.println(s_id+"\t"+s_name+"\t"+c_id+"\t"+assignment);
			}
			// try with resource so no need to close the connection - it will be closed automatically
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
