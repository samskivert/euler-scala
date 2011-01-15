object Euler065 extends EulerApp {
  case class Frac (numer :BigInt, denom :BigInt) {
    def + (n :BigInt) = Frac(n * denom + numer, denom)
    def invert = Frac(denom, numer)
  }
  def compute (count :Int, n :Int) :Frac = {
    val term = if (n == 1) 2 else if (n % 3 == 0) 2*(n/3) else 1
    if (n == count) Frac(term, 1)
    else compute(count, n+1).invert + term
  }
  def answer = compute(100, 1).numer.toString map(_-'0') sum
}
