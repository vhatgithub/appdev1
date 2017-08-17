import java.sql.SQLException;

public class UserBO {
	public User validatePassword(String username, String password) throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		return userDAO.validatePassword(username, password);
	}
}
