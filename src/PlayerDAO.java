import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
	public Boolean createPlayer(Player player) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		int id = player.getId();
		String name = player.getName();
		String country = player.getCountry();
		int teamId = player.getTeamId();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO player VALUES(?,?,?,?)");
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, country);
		pstmt.setInt(4, teamId);
		return pstmt.execute();
	}
	
	public int getPlayerIdPlayerName(String name) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT id FROM player WHERE name = ?");
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		int id = 0;
		while (rs.next()) {
			id = rs.getInt("id");
		}
		return id;
	}
	
	public List<Player> getAllPlayer() throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM player");
		ResultSet rs = pstmt.executeQuery();
		
		List<Player> playerList = new ArrayList<Player>();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String country = rs.getString("country");
			int teamId = rs.getInt("team_id");
			Player player = new Player(id, name, country, teamId);
			playerList.add(player);
		}
		return playerList;
	}
	
	public Player getPlayerById(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM player WHERE id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Player player = null;
		
		while (rs.next()) {
			String name = rs.getString("name");
			String country = rs.getString("country");
			int teamId = rs.getInt("team_id");
			player = new Player(id, name, country, teamId);
		}
		return player;
	}
}
