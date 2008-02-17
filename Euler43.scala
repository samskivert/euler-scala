object Euler43 extends Application {
  def perms (d :List[Char], n :List[Char]) :List[String] = {
    if (d == Nil) n.mkString :: Nil;
    else d.flatMap(digit => perms(d.filter(digit.!=), digit :: n))
  }
  def checkmod (n :String, off :Int, d :Int) :Boolean = (n.substring(off, off+3).toInt % d == 0);
  def ismatch (n :String) :Boolean = {
    checkmod(n, 1, 2) && checkmod(n, 2, 3) && checkmod(n, 3, 5) && checkmod(n, 4, 7) &&
    checkmod(n, 5, 11) && checkmod(n, 6, 13) && checkmod(n, 7, 17)
  }
  val matches = perms("0123456789".toList, Nil).filter(ismatch);
  println(matches.map(BigInt.apply).foldRight(BigInt(0))(_+_))
}
