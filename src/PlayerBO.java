import java.sql.SQLException;
import java.util.List;

public class PlayerBO {
	public Boolean createPlayer(Player player) throws ClassNotFoundException, SQLException {
		PlayerDAO playerDAO = new PlayerDAO();
		return playerDAO.createPlayer(player);
	}
	
	public int getPlayerIdPlayerName(String name) throws ClassNotFoundException, SQLException {
		PlayerDAO playerDAO = new PlayerDAO();
		return playerDAO.getPlayerIdPlayerName(name);
	}
	
	public List<Player> getAllPlayer() throws ClassNotFoundException, SQLException {
		PlayerDAO playerDAO = new PlayerDAO();
		return playerDAO.getAllPlayer();
	}
	
	public Player getPlayerById(int id) throws ClassNotFoundException, SQLException {
		PlayerDAO playerDAO = new PlayerDAO();
		return playerDAO.getPlayerById(id);
	}
}
