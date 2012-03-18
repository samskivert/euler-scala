object Euler112 extends EulerApp {
  def isinc (n :Int, pd :Int = 9) :Boolean =
    (n == 0) || (n%10 <= pd && isinc(n/10, n%10))
  def isdec (n :Int, pd :Int = 0) :Boolean =
    (n == 0) || (n%10 >= pd && isdec(n/10, n%10))
  def isbouncy (n :Int) = !isinc(n+1) && !isdec(n+1)
  def loop (n :Int, b :Int) :Int =
    if (99*n == 100*b) n
    else loop(n+1, if (isbouncy(n)) b+1 else b)
  def answer = loop(9, 0)
}
