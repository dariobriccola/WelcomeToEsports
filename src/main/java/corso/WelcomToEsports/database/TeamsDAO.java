package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import corso.WelcomToEsports.modelli.Game;
import corso.WelcomToEsports.modelli.Team;

public class TeamsDAO {
	
	private static TeamsDAO instance;

	private TeamsDAO() {
	}

	public static TeamsDAO getInstance() {
		if(instance == null) 
			instance = new TeamsDAO();
		return instance;
	}
	
	private HashMap<Integer, Team> readAll(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
		Team n = null;
		HashMap<Integer, Team> ris = new HashMap<Integer, Team>();
		for (HashMap<String, Object> record : listaMappe) {
			n = new Team();
			n.setId((int) record.get("id"));
			n.setNome_team((String) record.get("nome_team"));
			n.setNazione_team((String) record.get("nazione_team"));
			n.setGame(new Game());
			n.getGame().setId((int) record.get("id_games"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Team> read() {
		String query = "select T.id, nome_team, nazione_team, G.id as id_games from teams T left join games G on T.id_games=G.id;";
		return readAll(query);
	}
	
	public boolean create(HashMap<String, String> parametri) {
		String query = "insert into TEAMS (nome_team, nazione_team, id_games) values(?,?,?)";
		return update(query, 
				parametri.get("nome_team"), 
				parametri.get("nazione_team"), 
				parametri.get("id_games"));
	}
	
	public boolean update(HashMap<String, String> parametri) {
		String query = "update Teams set nome_team = ?, nazione_team = ?, id_games = ? where id = ?";
		return update(query, 
				parametri.get("nome_team"), 
				parametri.get("nazione_team"), 
				parametri.get("id_games"), 
				parametri.get("id"));
	}
	
	public boolean delete(HashMap<String, String> parametri) {
		String query = "delete from Teams where id = ?";
		return update(query, parametri.get("id"));
	}

}
