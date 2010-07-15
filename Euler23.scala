import scala.collection.mutable.Set;

object Euler23 {
  def divisors (x :Int) = 1 :: (for { 
    divis <- List.range(2, math.sqrt(x).toInt+1)
    if x % divis == 0
  } yield List(divis, x / divis).distinct).flatten

  val MAX = 28123;
  val abundant = List.range(1, MAX+1).filter(a => (a < divisors(a).sum)).toArray;

  def filter (abund :Array[Int], ints :Set[Int], a :Int, b :Int) :Set[Int] = {
    ints -= (abund(a) + abund(b));
    if (b == abund.length-1)
      if (a == abund.length-1) ints;
      else filter(abund, ints, a+1, 0);
    else filter(abund, ints, a, b+1);
  }
  def main (args :Array[String]) {
    println(filter(abundant, Set() ++ List.range(1, MAX+1), 0, 0).sum);
  }
}
