object Euler035 extends EulerApp {
  val primes = genprimes(1000000);
  def digits (value :Int) :Int = if (value == 0) 0 else 1 + digits(value/10);
  def rotate (value :Int, turns :Int) :Int = {
    val mod = Math.pow(10, digits(value)-turns).intValue()
    (value % mod) * Math.pow(10, turns).intValue() + (value / mod)
  }
  def circprime (n :Int) :Boolean = {
    List.range(0, digits(n)).foldRight(true)((t, b) => (b && (primes(rotate(n, t)) != 0)))
  }
  println(primes.filter(0.!=).filter(circprime).length);
}
