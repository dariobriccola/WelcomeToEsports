package corso.WelcomToEsports.modelli;

import java.sql.Date;

public class Matches extends Entity{
	
	private Date date;
	private Game game;
	private Team team;
	private int points_Home;
	private int points_Away;
	@Override
	public String toString() {
		return "Matches [date=" + date + ", game=" + game + ", team=" + team + ", points_Home=" + points_Home
				+ ", points_Away=" + points_Away + ", toString()=" + super.toString() + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getPoints_Home() {
		return points_Home;
	}
	public void setPoints_Home(int points_Home) {
		this.points_Home = points_Home;
	}
	public int getPoints_Away() {
		return points_Away;
	}
	public void setPoints_Away(int points_Away) {
		this.points_Away = points_Away;
	}

	
}
	
	