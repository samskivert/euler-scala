object Euler035 extends EulerApp {
  val primes = genprimevec(1000000)
  def digits (value :Int) :Int = if (value == 0) 0 else 1 + digits(value/10)
  def rotate (value :Int, turns :Int) = {
    val mod = math.pow(10, digits(value)-turns).intValue()
    (value % mod) * math.pow(10, turns).intValue() + (value / mod)
  }
  def circprime (n :Int) =
    (0 to digits(n)).foldRight(true)((t, b) => (b && (primes(rotate(n, t)) != 0)))
  def answer = primes.filter(_ != 0).filter(circprime).length
}
