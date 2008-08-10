object Euler46 extends EulerApp {
  def isgold (n :Int) = 1.to(Math.sqrt(n/2)).exists(s => isprime(n-2*s*s))
  def check (n :Int) :Int = if (isprime(n) || isgold(n)) check(n+2) else n
  println(check(3))
}
