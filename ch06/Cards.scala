object Cards extends App {

    object Suit extends Enumeration {
        type Suit = Value
        val Spade = Value("♠")
        val Club = Value("♣")
        val Heart = Value("♥")
        val Diamond = Value("♦")
        def isRed(card: Suit) = card == Heart || card == Diamond
    }

    for (suit <- Suit.values) { println(suit, Suit.isRed(suit)) }

}