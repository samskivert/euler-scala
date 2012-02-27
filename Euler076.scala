object Euler076 extends EulerApp {
  val smap = new scala.collection.mutable.HashMap[Pair[Int, Int],Int]
  def sums (n :Int, max :Int) :Int = smap.getOrElseUpdate((n, max), {
    (if (n <= max) 1 else 0) + 1.to(n-1).filter(max.>=).map(k => sums(n-k, k)).sum
  })
  def answer = sums(100, 99)
}
