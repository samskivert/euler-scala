object Euler032 extends EulerApp {
  def digits (n :Int) = n.toString.map(_ - '0')
  def ispan (a :Int, b :Int, n :Int) =
    (digits(a) ++ digits(n) ++ digits(b)).sortWith(_<_) == (1 to 9)
  def haspanfact (n :Int) = (2 until 100) exists(a => (n % a == 0 && ispan(a, n/a, n)))
  def answer = 1000 until 10000 filter(haspanfact) sum
}
