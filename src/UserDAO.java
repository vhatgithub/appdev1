import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public User validatePassword(String username, String password) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM WHERE username = ?");
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		
		User user = null;
		
		while (rs.next()) {
			String actualPassword = rs.getString("password");
			if (actualPassword.equals(password)) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				user = new User(id, name, username, actualPassword);
			}
		}
		return user;
	}
}
