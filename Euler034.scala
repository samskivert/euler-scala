object Euler034s extends EulerApp {
  val facts = Array(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
  def digfact (sum :Int, n :Int) :Int =
    if (n == 0) sum else digfact(facts(n % 10) + sum, n/10)
  def check (sum :Int, n :Int) :Int =
    if (n == 2000000) sum
    else if (digfact(0, n) == n) check(sum+n, n+1)
    else check(sum, n+1)
  def answer = check(0, 10)
}
