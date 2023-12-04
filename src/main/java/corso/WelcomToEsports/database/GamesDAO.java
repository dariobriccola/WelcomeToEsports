package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import corso.WelcomToEsports.modelli.Game;

public class GamesDAO {
	
	private static GamesDAO instance;

	private GamesDAO() {
	}

	public static GamesDAO getInstance() {
		if(instance == null) 
			instance = new GamesDAO();
		return instance;
	}

	private HashMap<Integer, Game> readAll(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
		Game n = null;
		HashMap<Integer, Game> ris = new HashMap<Integer, Game>();
		for (HashMap<String, Object> record : listaMappe) {
			n = new Game();
			n.setId((int) record.get("id"));
			n.setTitolo((String) record.get("titolo"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Game> read() {
		String query = "select id, titolo from games;";
		return readAll(query);
	}
	
	public boolean create(HashMap<String, String> parametri) {
		String query = "insert into games (titolo) values(?)";
		return update(query, 
				parametri.get("titolo"));
	}
	
	public boolean update(HashMap<String, String> parametri) {
		String query = "update games set titolo = ? where id = ?";
		return update(query, 
				parametri.get("titolo"),
				parametri.get("id"));
	}
	
	public boolean delete(HashMap<String, String> parametri) {
		String query = "delete from games where id = ?";
		return update(query, parametri.get("id"));
	}
}
