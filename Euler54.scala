import scala.io.Source;
import scala.runtime.RichString;

object Euler54 extends Application {
  val ranks = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')

  object Card {
    def compare (c1 :Card, c2 :Card) =
      if (c1.rank == c2.rank) c1.suit > c2.suit else c1.rank > c2.rank

    def compareList (l1 :List[Card], l2 :List[Card]) =
      (l1.length > l2.length) || (l1.length == l2.length && compare(l1(0), l2(0)))
  }

  class Card (s :String) {
    val suit :Char = s.charAt(1)
    val rank :Int = ranks.indexOf(s.charAt(0))
    override def toString () :String = "" + ranks(rank) + suit
  }

  object Hand {
    def group (cards :List[Card]) :List[List[Card]] =
      if (cards == Nil) Nil
      else {
        val g = cards.takeWhile(c => c.rank == cards.head.rank)
        g :: group(cards.drop(g.length))
      }
  }

  class Hand (cards :List[Card]) {
    val group = Hand.group(cards).sort(Card.compareList)

    def isPair () = group.head.length == 2
    def isTwoPair () = group(0).length == 2 && group(1).length == 2
    def isThree () = group.head.length == 3
    def isStraight () = !List.range(1, 5).exists(ii => cards(ii).rank != cards.head.rank-ii)
    def isFlush () = !cards.drop(1).exists(c => c.suit != cards.head.suit)
    def isFull () = group.head.length == 3 && group.last.length == 2
    def isFour () = group.head.length == 4
    def isRoyal () = cards.head.rank == 13 && isStraight() && isFlush()

    def score () = group.foldLeft(0)((a, b) => b.head.rank + a*0xF)

    def rank () =
      if (isRoyal) 0x900000
      else if (isFlush && isStraight) 0x800000 + cards.head.rank
      else if (isFour) 0x700000 + group.head.head.rank
      else if (isFull) 0x600000 + score
      else if (isFlush) 0x500000 + cards.head.rank
      else if (isStraight) 0x400000 + cards.head.rank
      else if (isThree) 0x300000 + score
      else if (isTwoPair) 0x200000 + score
      else if (isPair) 0x100000 + score
      else score

    override def toString () :String = cards.tail.foldLeft(""+cards.head)((a, b) => a+","+b)
  }

  def toHands (line :String) :Pair[Hand,Hand] = {
    val cards = line.split(' ').map(s => new Card(s))
    Pair(new Hand(cards.take(5).toList.sort(Card.compare)),
         new Hand(cards.drop(5).toList.sort(Card.compare)))
  }

  val lines = Source.fromFile("poker.txt").getLines
  println(lines.toList.map(toHands).filter(p => p._1.rank > p._2.rank).length)
}
