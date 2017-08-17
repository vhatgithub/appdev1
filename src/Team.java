
public class Team {
	private int id;
	private String name;
	private String coach;
	private int homeCity;
	private int captain;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(int id, String name, String coach, int homeCity, int captain) {
		super();
		this.id = id;
		this.name = name;
		this.coach = coach;
		this.homeCity = homeCity;
		this.captain = captain;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the coach
	 */
	public String getCoach() {
		return coach;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(String coach) {
		this.coach = coach;
	}
	/**
	 * @return the homeCity
	 */
	public int getHomeCity() {
		return homeCity;
	}
	/**
	 * @param homeCity the homeCity to set
	 */
	public void setHomeCity(int homeCity) {
		this.homeCity = homeCity;
	}
	/**
	 * @return the captain
	 */
	public int getCaptain() {
		return captain;
	}
	/**
	 * @param captain the captain to set
	 */
	public void setCaptain(int captain) {
		this.captain = captain;
	}
}
