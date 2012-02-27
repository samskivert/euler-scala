object Euler108 extends EulerApp {
  def find (base :Seq[Int], m :Int) :Int = {
    val s = base ++ factors(m)
    val sols = (s ++ s).groupBy(x => x).map(_._2.size).map(_+1).product/2+1
    if (sols > 1000) base.product * m
    else find(base, m+1)
  }
  def answer = find(primegen.take(6), 2)
}
