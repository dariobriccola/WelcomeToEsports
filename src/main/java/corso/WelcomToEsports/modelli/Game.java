package corso.WelcomToEsports.modelli;

public class Game extends Entity{
	
	private String titolo;

	@Override
	public String toString() {
		return titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	

}
