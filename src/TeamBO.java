import java.sql.SQLException;
import java.util.List;

public class TeamBO {
	public Boolean createTeam(Team team) throws ClassNotFoundException, SQLException {
		TeamDAO teamDAO = new TeamDAO();
		return teamDAO.createTeam(team);
	} 
	
	public Boolean updateTeam(int captain, Team team) throws ClassNotFoundException, SQLException {
		TeamDAO teamDAO = new TeamDAO();
		return teamDAO.updateTeam(captain, team);
	}
	
	public List<Team> getAllTeam() throws ClassNotFoundException, SQLException {
		TeamDAO teamDAO = new TeamDAO();
		return teamDAO.getAllTeam();
	}
	
	public Team getTeamById(int id) throws ClassNotFoundException, SQLException {
		TeamDAO teamDAO = new TeamDAO();
		return teamDAO.getTeamById(id);
	}
	
	public Team getTeamByTeamName(String name) throws ClassNotFoundException, SQLException { 
		TeamDAO teamDAO = new TeamDAO();
		return teamDAO.getTeamByTeamName(name);
	}
}
