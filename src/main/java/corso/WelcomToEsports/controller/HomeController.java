package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import corso.WelcomToEsports.database.GamesDAO;

@Controller
public class HomeController {
	
	// ./
	// apre la pagina con la lista dei giochi
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("listaGames", GamesDAO.getInstance().read());
		System.out.println("Sto eseguendo la request HOME");
		return "home.html";
	}
	
	// Opzionale mapping per aprire una pagina con 
	// form di inserimento nuovo games
	
	
	// ./newGames
	// che aggiunge il nuovo gioco al DB(insert into GAMES)
	// 1opzione: aprire una pagina di conferma inserimento
	// 2opzione: redirect:/
	@PostMapping("/newGame")
	public String newGame(@RequestParam HashMap<String, String> parametri) {
		GamesDAO.getInstance().create(parametri);
		System.out.println("GIOCO INSERITO NEL DB");
		return "redirect:/";
	}
	
	@PostMapping("/delGame")
	public String delGame(@RequestParam HashMap<String, String> parametri) {
		GamesDAO.getInstance().delete(parametri);
		System.out.println("Sto eseguendo la request DEL Game");
		return "redirect:/";
	}
	
	
	
	

}
