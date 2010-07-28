object Euler095 extends EulerApp {
  def follow (sums :Array[Int], start :Int, chain :List[Int]) :List[Int] = {
    val next = sums(chain.head)
    if (next >= sums.length) Nil
    else if (next == start) chain
    else if (chain.tail contains next) Nil
    else follow(sums, start, next :: chain)
  }

  def divisors (x :Int) = Set(1) ++
    (2 to (math.sqrt(x).toInt) filter(x%_ == 0) flatMap(n => List(n, x/n)))

  val MAX = 1000000
  val sumdivs = (0 to MAX) map(divisors(_).sum) toArray
  val chains = 0 to MAX map(n => follow(sumdivs, n, n :: Nil))
  def answer = chains reduceLeft((b,a) => if (a.length > b.length) a else b) sortWith(_<_) head
}
