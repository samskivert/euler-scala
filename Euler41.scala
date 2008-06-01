object Euler41 extends EulerApp {
  def perms (d :List[Char], n :List[Char]) :List[Int] = d match {
    case Nil => n.mkString.toInt :: Nil;
    case _ => d.flatMap(digit => perms(d.filter(digit.!=), digit :: n))
  }
  println(perms("1234567".toList, Nil).filter(isprime).foldLeft(0)(Math.max));
}
