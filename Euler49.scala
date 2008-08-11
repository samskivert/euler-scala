object Euler49 extends EulerApp {
  def sort (n :Int) = n.toString.toList.sort(_<_).mkString.toInt
  def ismem (n :Int, nn :Int) = isprime(nn) && sort(nn) == sort(n)
  def isseq (n :Int) = ismem(n, n+3330) && ismem(n, n+6660)
  def mkseq (n :Int) = List(n, n+3330, n+6660).mkString
  println(mkseq(1488.to(10000-6660).filter(isprime).filter(isseq).first))
}
