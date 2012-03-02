object Euler111 extends EulerApp {
  final val D = 10
  def gen (d :Int, cur :Long, digs :Int, left :Int) :Long = {
    if (digs == D) (if (isprime(cur)) cur else 0)
    else if (D-digs == left) gen(d, cur*10+d, digs+1, left-1)
    else (0 to 9) filter(n => (n > 0 || digs > 0) && (n != d || left > 0)) map(
      n => gen(d, cur*10+n, digs+1, if (n == d) left-1 else left)) sum
  }
  def answer = (0 to 9) flatMap { d => Seq(1, 2) map(k => gen(d, 0, 0, D-k)) find(_ != 0) } sum
}
