object Euler71 extends EulerApp {
  case class Frac (numer :Int, denom :Int) {
    def lessThan (o :Frac) = numer*o.denom < o.numer*denom
    def reduce = {
      val div = gcd(numer, denom)
      Frac(numer/div, denom/div)
    }
    def delta = 3d/7 - numer.toDouble/denom
  }

  val fracs = 3.to(1000000).map(n => Frac(3*n/7, n)).filter(_.lessThan(Frac(3, 7))).toList
  println(fracs.sort(_.lessThan(_)).last)
}
