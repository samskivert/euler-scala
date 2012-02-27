object Euler033 extends EulerApp {
  def equal (ratio :Double, rnum :Int, rdenom :Int) :Boolean =
    (rdenom > 0) && (ratio == rnum/rdenom.doubleValue())
  val fracs = for {
    denom <- List.range(10,100)
    num <- List.range(10,denom)
    if ((num%10 == denom/10 && equal(num/denom.doubleValue(), num/10, denom%10)) ||
        (num/10 == denom%10 && equal(num/denom.doubleValue(), num%10, denom/10)))
  } yield (num, denom)
  val prod = fracs.foldRight((1,1))((b, a) => ((b._1 * a._1, b._2 * a._2)))
  def answer = prod._2 / prod._1
}
