package corso.WelcomToEsports.modelli;

import java.sql.Date;

public class Player extends Entity{
	
	private String nickname;
	private String nome;
	private String cognome;
	private Date data_Nascita;
	private String games_Role;
	private String nomeTeam;
	private Team team;
	
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_Nascita() {
		return data_Nascita;
	}

	public void setData_Nascita(Date data_Nascita) {
		this.data_Nascita = data_Nascita;
	}

	public String getGames_Role() {
		return games_Role;
	}

	public void setGames_Role(String games_Role) {
		this.games_Role = games_Role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getNomeTeam() {
		return nomeTeam;
	}

	public void setNomeTeam(String nomeTeam) {
		this.nomeTeam = nomeTeam;
	}

	@Override
	public String toString() {
		return "Player [nickname=" + nickname + ", nome=" + nome + ", cognome=" + cognome + ", data_Nascita="
				+ data_Nascita + ", games_Role=" + games_Role + ", nomeTeam=" + nomeTeam + ", team=" + team
				+ ", toString()=" + super.toString() + "]";
	}

	
	

}
