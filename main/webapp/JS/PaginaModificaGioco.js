$(document).ready(function() {
    const gamesDatabase = [
        {
            id: 1,
            name: "Death Stranding",
            description: "Dopo una serie di devastanti esplosioni congiunte in punti nevralgici del pianeta...",
            genere: "Avventura",
            cover: "deathStranding.jpg",
            price: 79.99,
            releaseDate: "2021-03-03",
            offers: "Sconto 20%",
        },
        {
            id: 2,
            name: "The Witcher 3: Wild Hunt",
            description: "Un epico RPG che segue le avventure del cacciatore di mostri Geralt di Rivia.",
            genere: "RPG",
            cover: "thewitcher3-cover.jpg",
            price: 59.99,
            releaseDate: "2015-05-19",
            offers: ["Limited Edition"],
        },
    ];

    const generiDisponibili = ["Avventura", "Azione", "Strategia", "RPG"];
    const offerteDisponibili = ["Nessuna", "Sconto 10%", "Sconto 20%", "Sconto 50%"];

    function populateGameSelect() {
        const gameSelect = $('#gameSelect');
        gamesDatabase.forEach(game => {
            gameSelect.append(`<option value="${game.id}">${game.name}</option>`);
        });
    }

    function populateGenereSelect() {
        const genereSelect = $('#genere');
        generiDisponibili.forEach(genere => {
            genereSelect.append(`<option value="${genere}">${genere}</option>`);
        });
    }

    function populateOfferteSelect() {
        const offerteSelect = $('#offers');
        offerteDisponibili.forEach(offer => {
            offerteSelect.append(`<option value="${offer}">${offer}</option>`);
        });
    }

    populateGameSelect();
    populateGenereSelect();
    populateOfferteSelect();

    $('.fieldCheckbox').change(function() {
        const field = $(this).val();
        if($(this).is(':checked')) {
            $(`#field-${field}`).removeClass('hidden');
        } else {
            $(`#field-${field}`).addClass('hidden');
        }

        if($('.fieldCheckbox:checked').length > 0 && $('#gameSelect').val() !== "") {
            $('#modifyFields').slideDown();
        } else {
            $('#modifyFields').slideUp();
        }
    });

    $('#gameSelect').change(function() {
        const gameId = $(this).val();
        if(gameId === "") {
            $('#modifyFields').slideUp();
            $('.fieldCheckbox').prop('checked', false);
            $('.hidden').addClass('hidden');
            $('#message').addClass('hidden').text('');
            return;
        }

        const selectedGame = gamesDatabase.find(game => game.id == gameId);
        if(selectedGame) {
            $('#name').val(selectedGame.name);
            $('#description').val(selectedGame.description);
            $('#price').val(selectedGame.price);
            $('#genere').val(selectedGame.genere);
            $('#cover').val(selectedGame.cover);
            $('#releaseDate').val(selectedGame.releaseDate);
            $('#offers').val(selectedGame.offers);
        }

        if($('.fieldCheckbox:checked').length > 0) {
            $('#modifyFields').slideDown();
        } else {
            $('#modifyFields').slideUp();
        }
    });

    $('#modifyForm').submit(function(e) {
        e.preventDefault();

        const gameId = $('#gameSelect').val();
        const selectedGameIndex = gamesDatabase.findIndex(game => game.id == gameId);

        if(selectedGameIndex === -1) {
            showMessage('Gioco non trovato.', 'error');
            return;
        }

        $('.fieldCheckbox:checked').each(function() {
            const field = $(this).val();
            const newValue = $(`#${field}`).val();

            if(field === 'name' || field === 'description' || field === 'genere') {
                if(newValue.trim() === "") {
                    showMessage(`Il campo ${field} non può essere vuoto.`, 'error');
                    return false;
                }
            }

            if(field === 'price') {
                if(newValue === "" || isNaN(newValue) || Number(newValue) < 0) {
                    showMessage('Inserisci un prezzo valido.', 'error');
                    return false;
                }
                gamesDatabase[selectedGameIndex][field] = parseFloat(newValue).toFixed(2);
            } else {
                gamesDatabase[selectedGameIndex][field] = newValue;
            }
        });

        showMessage('Modifiche salvate con successo!', 'success');

        $('#modifyFields').slideUp();
        $('.fieldCheckbox').prop('checked', false);
        $('.hidden').addClass('hidden');

        const updatedGame = gamesDatabase[selectedGameIndex];
        $('#gameSelect option[value="' + updatedGame.id + '"]').text(updatedGame.name);
    });

    function showMessage(message, type) {
        const messageDiv = $('#message');
        messageDiv.removeClass('hidden').removeClass('success error').addClass(type).text(message);

        setTimeout(() => {
            messageDiv.addClass('hidden').text('');
        }, 3000);
    }
});


    