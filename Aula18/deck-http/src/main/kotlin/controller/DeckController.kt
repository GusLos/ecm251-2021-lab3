package controller

import model.Card
import model.Deck
import org.json.JSONArray
import org.json.JSONObject
import service.HttpService
import shared.DeckOfCardsAPIConstants

class DeckController {
    val deck : Deck
    constructor(){
        val resposta = HttpService.getJson(DeckOfCardsAPIConstants.newDeckUrl)
        this.deck = Deck(resposta["deck_id"] as String)
    }

    public fun drawCard() : Card {
        val resposta_carta = HttpService.getJson(DeckOfCardsAPIConstants.getOneCardUrl(this.deck.deckId))
        val valores_das_cartas : JSONArray = resposta_carta["cards"] as JSONArray
        val primeira_carta = valores_das_cartas[0] as JSONObject
        return Card(primeira_carta["suit"] as String,primeira_carta["value"] as String,primeira_carta["image"] as String)
    }
}