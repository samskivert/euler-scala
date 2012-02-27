object Euler041 extends EulerApp {
  def perms (d :List[Char], n :List[Char]) :List[Int] = d match {
    case Nil => n.mkString.toInt :: Nil
    case _ => d.flatMap(digit => perms(d.filter(digit.!=), digit :: n))
  }
  def answer = perms("1234567".toList, Nil).filter(isprime).max
}
