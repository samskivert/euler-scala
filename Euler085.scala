object Euler085 extends EulerApp {
  def rects (n:Int, m:Int) = n*(n+1)*m*(m+1)/4
  def answer = {
    val rs = for (x <- 1 to 99; y <- 1 to 99) yield (x*y, math.abs(rects(x,y)-2000000))
    rs.sortBy(_._2).head._1
  }
}
