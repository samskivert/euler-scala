import scala.collection.mutable.Set;

object Euler23 extends Application {
  def sum (values :List[Int]) = {
    values.foldLeft(0)(_+_)
  }

  def divisors (x :Int) :List[Int] = {
    1 :: List.flatten(for { 
      divis <- List.range(2, Math.sqrt(x)+1)
      if x % divis == 0
    } yield List(divis, x / divis).removeDuplicates);
  }

  val max = 28123;
  var abundant = (for {
    a <- List.range(1, max+1)
    if (a < sum(divisors(a)))
  } yield a).toArray;

  var integers = Set() ++ List.range(1, max+1);
  for (a <- List.range(0, abundant.length)) {
    for (b <- List.range(a, abundant.length)) {
      integers -= (abundant(a) + abundant(b));
    }
  }
  println(sum(integers.toList));
}
