import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
	public City getCityById(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT id, name FROM city WHERE id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		City city = null;
		
		while (rs.next()) {
			String cityName = rs.getString("name");
			city = new City(id, cityName);
		}
		return city;
	}
	
	public List<City> getAllCities() throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM city");
		ResultSet rs = pstmt.executeQuery();
		List<City> cityList = new ArrayList<City>();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			City city = new City(id, name);
			cityList.add(city);
		}
		return cityList;
	}
}
