import scala.collection.mutable.Set;

object Euler23 extends Application {
  def sumdiv (x :Int) :Int = (1 :: List.flatten(for { 
    divis <- List.range(2, Math.sqrt(x)+1)
    if x % divis == 0
  } yield List(divis, x / divis).removeDuplicates)).foldLeft(0)(_+_);

  val max = 28123;
  val abundant = List.range(1, max+1).filter(a => (a < sumdiv(a))).toArray;

  def filter (abund :Array[Int], ints :Set[Int], a :Int, b :Int) :Set[Int] = {
    ints -= (abund(a) + abund(b));
    if (b == abund.length-1)
      if (a == abund.length-1) return ints;
      else return filter(abund, ints, a+1, 0);
    else return filter(abund, ints, a, b+1);
  }
  println(filter(abundant, Set() ++ List.range(1, max+1), 0, 0).foldLeft(0)(_+_));
}
