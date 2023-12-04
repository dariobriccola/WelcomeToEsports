
class Game {
	constructor(titolo) {
		this.titolo = titolo;
	}

	listItem() {
		return "<li onclick=\"renderDettGames('" + this.titolo + "')\">" + this.titolo + "</li>";
	}

	dettGame() {
		return "<p>Titolo: " + this.titolo + "</p>";
	}
}

function renderDettGames(game) {
	document.getElementById('modal-dett-game').style.display = 'block';
	document.getElementById('mod-id').value = player.getAttribute('data-id');
	document.getElementById('mod-titolo').value = player.getAttribute('data-titolo');
}


/*
	document.getElementById('modal-dett-player').style.display = 'block';
*/


function pulisciNewGame() {
    // Seleziona l'elemento input per il titolo del gioco
    var titoloInput = document.getElementById('titoloGame');

    // Azzeramento del valore dell'input del titolo del gioco
    titoloInput.value = '';
}


function init() {
	document.getElementById("btn-new-game").onclick = function() {
		document.getElementById('modal-new-game').style.display = 'block';
	}
	document.getElementById("close-modal-new").onclick = function() {
		document.getElementById("modal-new-game").style.display = "none";
	}
	
}
/*
function redirectToTeam(elemento) {
   
    let idGame = elemento.getAttribute("th:data-id");
    let titoloGame = elemento.getAttribute("th:data-titolo");

    
    let url = "/team/?idGames=" + encodeURIComponent(idGame) + "&idTeam=" + encodeURIComponent(titoloGame);

    
    window.location.href = url;
}
*/

