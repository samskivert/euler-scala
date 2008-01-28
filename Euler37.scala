object Euler37 extends EulerApp {
  val primes = genprimes(1000000);
  def isrtrunc (prime :Int) :Boolean = {
    (prime == 0) || ((primes(prime) != 0) && isrtrunc(prime/10));
  }
  def isltrunc (digits :List[Char]) :Boolean = {
    (digits == Nil) || ((primes(digits.mkString.toInt) != 0) && isltrunc(digits.tail));
  }
  def istrunc (prime :Int) = isrtrunc(prime) && isltrunc(prime.toString.toList)
  println(primes.drop(10).filter(0.!=).filter(istrunc).foldRight(0)(_+_));
}
