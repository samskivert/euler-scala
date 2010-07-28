object Euler072 extends EulerApp {
  val primes = genprimes(Math.sqrt(1000000)).filter(0.!=)
  def phi (n :Int) = primefacts(primes, n).foldLeft(n.toLong)((b, a) => (b * (a-1) / a))
  println(2.to(1000000).map(phi).reduceLeft(_+_))
}
