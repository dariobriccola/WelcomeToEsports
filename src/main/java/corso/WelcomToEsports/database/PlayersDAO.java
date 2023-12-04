package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import corso.WelcomToEsports.modelli.Player;
import corso.WelcomToEsports.modelli.Team;

public class PlayersDAO {
	
	private static PlayersDAO instance;

	private PlayersDAO() {
	}

	public static PlayersDAO getInstance() {
		if(instance == null) 
			instance = new PlayersDAO();
		return instance;
	}
	
	private HashMap<Integer, Player> readAll(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
		Player n = null;
		HashMap<Integer, Player> ris = new HashMap<Integer, Player>();
		for (HashMap<String, Object> record : listaMappe) {
			n = new Player();
			n.setId((int) record.get("id"));
			n.setNickname((String) record.get("nickname"));
			n.setNome((String) record.get("nome"));
			n.setCognome((String) record.get("cognome"));
			n.setData_Nascita((Date) record.get("data_Nascita"));
			n.setGames_Role((String) record.get("games_Role"));
			n.setTeam(new Team());
			n.getTeam().setId((int) record.get("id_team"));
			n.getTeam().setNome_team((String) record.get("nome_team"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	//select P.id, nickname, P.nome, cognome, data_Nascita, games_Role, T.id as id_team, T.nome_team as nome_team from PLAYERS P left join TEAMS T on P.id_team = T.id;
	public HashMap<Integer, Player> read() {
		String query = "select P.id, nickname, P.nome, cognome, data_Nascita, games_Role, T.id as id_team, T.nome_team as nome_team from PLAYERS P left join TEAMS T on P.id_team = T.id";
		return readAll(query);
	}
	
	public boolean create(HashMap<String, String> parametri) {
		String query = "insert into PLAYERS(nickname, nome, cognome, data_Nascita, games_Role, id_team) values(?,?,?,?,?,?)";
		return update(query, 
				parametri.get("nickname"), 
				parametri.get("nome"), 
				parametri.get("cognome"), 
				parametri.get("data_Nascita"), 
				parametri.get("games_Role"), 
				parametri.get("id_team"));
	}
	
	public boolean update(HashMap<String, String> parametri) {
		String query = "update PLAYERS set nickname = ?, nome = ?, cognome = ?, data_Nascita = ?, games_Role = ?, id_team = ? where id = ?";
		return update(query, 
				parametri.get("nickname"), 
				parametri.get("nome"), 
				parametri.get("cognome"), 
				parametri.get("data_Nascita"), 
				parametri.get("games_Role"), 
				parametri.get("id_team"), 
				parametri.get("id"));
	}
	
	public boolean delete(HashMap<String, String> parametri) {
		String query = "delete from PLAYERS where id = ?";
		return update(query, parametri.get("id"));
	}
	

}
