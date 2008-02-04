object Euler41 extends EulerApp {
  def isprime (n :Int) :Boolean = {
    List.range(2, Math.sqrt(n).toInt).foldRight(true)((d, p) => p && (n % d != 0))
  }
  def perms (d :List[Char], n :List[Char]) :List[Int] = {
    if (d == Nil) n.mkString.toInt :: Nil;
    else d.flatMap(digit => perms(d.filter(digit.!=), digit :: n))
  }
  println(perms("1234567".toList, Nil).filter(isprime).foldRight(0)(Math.max));
}
