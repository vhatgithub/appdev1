import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CityBO {
	public City getCityById(int id) throws ClassNotFoundException, SQLException {
		CityDAO cityDAO = new CityDAO();
		City city = cityDAO.getCityById(id);
		return city;
	}
	
	public List<City> getAllCities() throws ClassNotFoundException, SQLException {
		CityDAO cityDAO = new CityDAO();
		List<City> cityList = cityDAO.getAllCities();
		return cityList;
	}
}
