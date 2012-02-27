object Euler054 extends EulerApp {
  class Card (s :String) {
    val suit :Char = s.charAt(1)
    val rank :Int = "23456789TJQKA".indexOf(s.charAt(0))
    def > (o :Card) = if (rank == o.rank) suit > o.suit else rank > o.rank
  }

  class Hand (c :Seq[Card]) {
    def groupCards (cards :List[Card]) :List[List[Card]] =
      if (cards.isEmpty) Nil else {
        val g = cards.takeWhile(_.rank == cards.head.rank)
        g :: groupCards(cards.drop(g.length))
      }

    val cards = c.toList.sortWith(_>_)
    val group = groupCards(cards).sortWith((l1, l2) =>
      (l1.length > l2.length) || (l1.length == l2.length && l1(0) > l2(0)))

    def isPair () = group.head.length == 2
    def isTwoPair () = group(0).length == 2 && group(1).length == 2
    def isThree () = group.head.length == 3
    def isStraight () = !(1 until 5).exists(ii => cards(ii).rank != cards.head.rank-ii)
    def isFlush () = !cards.tail.exists(_.suit != cards.head.suit)
    def isFull () = group.head.length == 3 && group.last.length == 2
    def isFour () = group.head.length == 4
    def isRoyal () = cards.head.rank == 13 && isStraight && isFlush

    val score = group.foldLeft(0)((b, a) => a.head.rank + b*0xF)

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
  }

  def toHands (line :String) = {
    val cards = line.split(' ').map(s => new Card(s))
    (new Hand(cards.take(5)), new Hand(cards.drop(5)))
  }

  def answer = readlines("poker.txt").map(toHands).filter(p => p._1.rank > p._2.rank).length
}
