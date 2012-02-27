object Euler073 extends EulerApp {
  val primes = genprimes(math.sqrt(10000).toInt)
  def iscoprime (denom :Int) = {
    val pfacts = primefacts(primes, denom)
    (numer :Int) => !pfacts.exists(p => (numer%p)==0)
  }
  def answer = (4 to 10000).map(d => (d/3+1).to(d/2).filter(iscoprime(d)).length).sum
}
