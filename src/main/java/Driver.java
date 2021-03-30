
import java.sql.Connection;
import java.sql.SQLException;

import com.banking.utils.*;

public class Driver {

	public static void main(String[] args) {

		//tests our connection
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		StartMenu start = new StartMenu();
		start.startMenu();
		
		

	}

}
