object Euler109 extends EulerApp {
  val singles = (1 to 20) :+ 25
  val doubles = singles map(_*2)
  val triples = 1 to 20 map(_*3)
  val zones = (singles ++ doubles ++ triples) sortBy(-_) toList

  // e.g. List(1, 2, 3) -> List(List(1, 2, 3), List(2, 3), List(3))
  def tails[A] (l :List[A]) :List[List[A]] = if (l.isEmpty) Nil else l :: tails(l.tail)

  def checkouts (score :Int) = {
    def outs (points :Int, darts :Int, zs :List[Int]) :Int = {
      if (points == 0) 1
      else if (darts == 0) 0
      else tails(zs dropWhile(_ > points)) map(t => outs(points-t.head, darts-1, t)) sum
    }
    doubles takeWhile(_ <= score) map(d => outs(score-d, 2, zones)) sum
  }

  def answer = 1 until 100 map(checkouts) sum
}
