object Euler35 extends EulerApp {
  val primes = genprimes(1000000);
  def digits (value :Int) :Int = if (value == 0) 0 else 1 + digits(value/10);
  def rotate (value :Int, turns :Int) :Int = {
    if (turns == 0) value;
    else rotate(value%10 * Math.pow(10, digits(value)-1).intValue() + value/10, turns-1);
  }
  def circprime (n :Int) :Boolean = {
    List.range(0, digits(n)).foldRight(true)((turns, b) => (b && (primes(rotate(n, turns)) != 0)))
  }
  println(List.range(2,1000000).filter((n) => (primes(n) != 0)).filter(circprime).length);
}
