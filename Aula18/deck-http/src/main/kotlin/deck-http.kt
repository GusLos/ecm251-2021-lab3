import controller.DeckController
import model.Card
import org.json.JSONArray
import org.json.JSONObject

fun main(args: Array<String>) {
    val deckController = DeckController()
    val carta = deckController.drawCard()
    println(carta)
}