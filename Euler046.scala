object Euler046 extends EulerApp {
  def isgold (n :Int) = (1 to math.sqrt(n/2).toInt).exists(s => isprime(n-2*s*s))
  def check (n :Int) :Int = if (isprime(n) || isgold(n)) check(n+2) else n
  def answer = check(3)
}
