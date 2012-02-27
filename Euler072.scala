object Euler072 extends EulerApp {
  val primes = genprimes(math.sqrt(1000000).toInt)
  def phi (n :Int) = primefacts(primes, n).foldLeft(n.toLong)((b, a) => (b * (a-1) / a))
  def answer = 2.to(1000000).map(phi).sum
}
