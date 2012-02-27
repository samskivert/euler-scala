object Euler088 extends EulerApp {
  def minprodsum (mins :Array[Int], n :Int, p :Int, s :Int, l :Int) {
    val np = p * n
    val k = np - (s+n) + (l+1)
    if (k < mins.length) {
      mins(k) = math.min(np, mins(k))
      minprodsum(mins, n, np, s+n, l+1)
    }
    if (n > 2) minprodsum(mins, n-1, p, s, l)
  }
  def answer = {
    val mins = Array.tabulate(12001)(2*_)
    minprodsum(mins, 12000, 1, 0, 0)
    mins.drop(2).toList.distinct.sum
  }
}
