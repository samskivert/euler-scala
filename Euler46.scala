object Euler46 extends EulerApp {
  def isgold (n :Int) :Boolean =
    List.range(1, Math.sqrt(n/2).toInt+1).exists(s => isprime(n-2*s*s));
  def check (n :Int) :Int = if (isprime(n) || isgold(n)) check(n+2) else n;
  println(check(3));
}
