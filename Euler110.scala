object Euler110 extends EulerApp {
  def find (base :Seq[Int], m :Int) :Long = {
    val s = base ++ factors(m)
    val sols = (s ++ s).groupBy(x => x).map(_._2.size).map(_+1).product/2+1
    if (sols > 4000000) base.map(_.toLong).product * m
    else find(base, m+1)
  }
  def answer = find(primegen.take(12), 2)
}
