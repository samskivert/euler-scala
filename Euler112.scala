object Euler112 extends EulerApp {
  def check (n :Int, pd :Int, comp :(Int, Int) => Boolean) :Boolean =
    (n == 0) || (comp(n%10, pd) && check(n/10, n%10, comp))
  def isbouncy (n :Int) = !check(n+1, 9, _ <= _) && !check(n+1, 0, _ >= _)
  def loop (n :Int, b :Int) :Int =
    if (99*n == 100*b) n
    else loop(n+1, if (isbouncy(n)) b+1 else b)
  def answer = loop(9, 0)
}
