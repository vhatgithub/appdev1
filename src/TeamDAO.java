import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
	public Boolean createTeam(Team team) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		int id = team.getId();
		String name = team.getName();
		String coach = team.getCoach();
		int homeCity = team.getHomeCity();
		int captain = team.getCaptain();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO team VALUES(?,?,?,?,?)");
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, coach);
		pstmt.setInt(4, homeCity);
		pstmt.setInt(5, captain);
		return pstmt.execute();
	} 
	
	public Boolean updateTeam(int captain, Team team) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		int id = team.getId();
		String name = team.getName();
		String coach = team.getCoach();
		int homeCity = team.getHomeCity();
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE team SET id = ?, name = ?, coach = ?, home_city_id = ? WHERE captain = ?");
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, coach);
		pstmt.setInt(4, homeCity);
		pstmt.setInt(5, captain);
		return pstmt.execute();
	}
	
	public List<Team> getAllTeam() throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM team");
		ResultSet rs = pstmt.executeQuery();
		
		List<Team> teamList = new ArrayList<Team>();
		 while (rs.next()) {
			 int id = rs.getInt("id");
			 String name = rs.getString("name");
			 String coach = rs.getString("coach");
			 int homeCity = rs.getInt("home_city_id");
			 int captain = rs.getInt("captain");
			 Team team = new Team(id, name, coach, homeCity, captain);
			 teamList.add(team);
		 }
		 return teamList;
	}
	
	public Team getTeamById(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM team WHERE id = ?");
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		Team team = null;
		
		while (rs.next()) {
			String name = rs.getString("name");
			String coach = rs.getString("coach");
			int homeCity = rs.getInt("home_city_id");
			int captain = rs.getInt("captain");
			team = new Team(id, name, coach, homeCity, captain);
		}
		return team;
	}
	
	public Team getTeamByTeamName(String name) throws ClassNotFoundException, SQLException { 
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM team WHERE name = ?");
		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		Team team = null;
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String coach = rs.getString("coach");
			int homeCity = rs.getInt("home_city_id");
			int captain = rs.getInt("captain");
			team = new Team(id, name, coach, homeCity, captain);
		}
		return team;
	}
}
