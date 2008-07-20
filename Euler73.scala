object Euler73 extends EulerApp {
  val primes = genprimes(Math.sqrt(10000)).filter(0.!=)
  def iscoprime (denom :Int) = {
    val pfacts = primefacts(primes, denom)
    (numer :Int) => !pfacts.exists(p => (numer%p)==0)
  }
  def irrfracs (d :Int) = ((d.toFloat/3).ceil.toInt).to(d/2).filter(iscoprime(d)).length
  println(4.to(10000).map(irrfracs).sum)
}
