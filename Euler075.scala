object Euler075 extends EulerApp {
  val Max = 2000000
  val tris = new Array[Int](Max+1)
  for (m <- 2.to(1000); n <- 1.to(m-1)) {
    if (gcd(m, n) == 1 && (m + n) % 2 == 1) {
      val perim = 2 * m * (m + n)
      for (k <- 1.to(Max/perim)) tris(k * perim) += 1
    }
  }
  def answer = tris.filter(_ == 1).length
}
