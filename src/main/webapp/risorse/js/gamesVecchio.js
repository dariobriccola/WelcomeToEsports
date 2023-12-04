/*
class Game {
	constructor(titolo) {
		this.titolo = titolo;
	}

	listItem() {
		return "<li onclick=\"renderDettPlayer('" + this.titolo + "')\">" + this.titolo + "</li>";
	}

	dettGame() {
		return "<p>Nickname: " + this.titolo + "</p>";
	}
}

function renderDettGames(player) {
	document.getElementById('modal-dett-game').style.display = 'block';
	document.getElementById('mod-id').value = player.getAttribute('data-id');
	document.getElementById('mod-titolo').value = player.getAttribute('data-titolo');
}
*/

/*
	document.getElementById('modal-dett-player').style.display = 'block';
*/

/*
function pulisciNewGame() {
	for (let input of document.querySelectorAll("#modal-new-game > .modal-content > input")) {
		input.value = "";
	}
	document.querySelector("#modal-new-game > .modal-content > select").value = "";
}
*/

/*	
function init() {
document.getElementById("btn-new-game").onclick = function () {
	document.getElementById('modal-new-game').style.display = 'block';
	}
}
*/
// Ottieni il riferimento al pulsante "Nuovo Game" e al modal
const btnNewGame = document.getElementById('btn-new-game');
const modalNewGame = document.getElementById('modal-new-game');
const closeModalBtn = document.getElementById('close-modal-new');
const clearGameBtn = document.getElementById('clear-game');
const gameList = document.getElementById('game-list');

btnNewGame.addEventListener('click', () => {
    modalNewGame.style.display = 'block';
});

closeModalBtn.addEventListener('click', () => {
    modalNewGame.style.display = 'none';
});

clearGameBtn.addEventListener('click', () => {
    document.getElementById('new-game-form').reset();
});

document.getElementById('new-game-form').addEventListener('submit', (event) => {
    event.preventDefault();

    const gameTitle = document.getElementById('game-title').value.trim();
    if (gameTitle !== '') {
        const li = document.createElement('li');
        li.innerHTML = `
            <p>${gameTitle}</p>
            <button onclick="renderDettGames(this)">Dettaglio</button>
            <form action="/delGame" method="post" onsubmit="return confirm('Vuoi davvero eliminare ?');">
                <input type="hidden" name="id" value="${generateRandomId()}">
                <button>Elimina</button>
            </form>
        `;
        gameList.appendChild(li);

        modalNewGame.style.display = 'none';
    }
});

function generateRandomId() {
    return Math.random().toString(36).substr(2, 9);
}
