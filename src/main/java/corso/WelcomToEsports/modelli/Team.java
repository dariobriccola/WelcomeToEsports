package corso.WelcomToEsports.modelli;

public class Team extends Entity{
	
	private String nome_team;
	private String nazione_team;
	private Game game;
	
	@Override
	public String toString() {
		return "Team [nome_team=" + nome_team + ", nazione_team=" + nazione_team + ", game=" + game
				+ ", toString()=" + super.toString() + "]";
	}

	public String getNome_team() {
		return nome_team;
	}

	public void setNome_team(String nome_team) {
		this.nome_team = nome_team;
	}

	public String getNazione_team() {
		return nazione_team;
	}

	public void setNazione_team(String nazione_team) {
		this.nazione_team = nazione_team;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	

	
	
	

}
