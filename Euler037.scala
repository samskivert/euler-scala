object Euler037 extends EulerApp {
  val primes = genprimevec(1000000)
  def isrtrunc (prime :Int) :Boolean =
    (prime == 0) || ((primes(prime) != 0) && isrtrunc(prime/10))
  def isltrunc (prime :String) :Boolean =
    prime.isEmpty || ((primes(prime.toInt) != 0) && isltrunc(prime.substring(1)))
  def istrunc (prime :Int) = isrtrunc(prime) && isltrunc(prime.toString)
  def answer = primes.drop(10).filter(_ != 0).filter(istrunc).sum
}
