import scala.collection.mutable.Set

object Euler023s extends EulerApp {
  def divisors (x :Int) = Set(1) ++
    (2 to (math.sqrt(x).toInt) filter(x%_ == 0) flatMap(n => List(n, x/n)))

  def filter (abund :Array[Int], ints :Set[Int], a :Int, b :Int) :Set[Int] = {
    ints -= (abund(a) + abund(b))
    if (b == abund.length-1)
      if (a == abund.length-1) ints
      else filter(abund, ints, a+1, 0)
    else filter(abund, ints, a, b+1)
  }

  val MAX = 28123
  val abundant = 1 until MAX filter(a => (a < divisors(a).sum)) toArray
  def answer = filter(abundant, Set() ++ List.range(1, MAX+1), 0, 0).sum
}
