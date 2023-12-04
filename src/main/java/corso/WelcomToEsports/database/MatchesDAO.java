package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import corso.WelcomToEsports.modelli.Game;
import corso.WelcomToEsports.modelli.Matches;
import corso.WelcomToEsports.modelli.Team;

public class MatchesDAO {
	
	private static MatchesDAO instance;

	private MatchesDAO() {
	}

	public static MatchesDAO getInstance() {
		if(instance == null) 
			instance = new MatchesDAO();
		return instance;
	}
	
	private HashMap<Integer, Matches> readAll(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
		Matches n = null;
		HashMap<Integer, Matches> ris = new HashMap<Integer, Matches>();
		for (HashMap<String, Object> record : listaMappe) {
			n = new Matches();
			n.setId((int) record.get("match_Id"));
			n.setDate((Date) record.get("data_Match"));
			n.setGame(new Game());
			n.getGame().setId((int) record.get("id_Games"));
			n.setTeam(new Team());
			n.getTeam().setId((int) record.get("id_Team_Home"));
			n.getTeam().setId((int) record.get("id_Team_Away"));
			n.setPoints_Home((int) record.get("points_Home"));
			n.setPoints_Away((int) record.get("points_Away"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Matches> read() {
		String query = "SELECT m.id as match_Id, g.titolo, data_Match, m.id_Team_Home, th.nome_team, m.points_Home, m.points_Away, m.id_Team_Away AS Away_Team_ID, ta.nome_team AS Away_Team_Name  FROM matches m JOIN teams th ON m.id_Team_Home = th.id JOIN teams ta ON m.id_Team_Away = ta.id join games G on m.id_Games=g.id";
		return readAll(query);
	}
	
	public boolean create(HashMap<String, String> parametri) {
		String query = "insert into matches(data_Match, id_Games, id_Team_Home, id_Team_Away, points_Home, points_Away) values(?,?,?,?,?,?)";
		return update(query, 
				parametri.get("data_Match"), 
				parametri.get("id_Games"), 
				parametri.get("id_Team_Home"), 
				parametri.get("id_Team_Away"),
				parametri.get("points_Home"),
				parametri.get("points_Away"));
	}
	
	public boolean update(HashMap<String, String> parametri) {
		String query = "update matches set data_Match = ?, id_Games = ?, id_Team_Home = ?, id_Team_Away = ?,points_Home = ?,points_Away = ? where id = ?";
		return update(query, 
				parametri.get("data_Match"), 
				parametri.get("id_Games"), 
				parametri.get("id_Team_Home"), 
				parametri.get("id_Team_Away"), 
				parametri.get("points_Home"), 
				parametri.get("points_Away"), 
				parametri.get("id"));
	}
	
	public boolean delete(HashMap<String, String> parametri) {
		String query = "delete from matches where id = ?";
		return update(query, parametri.get("id"));
	}
	

}
