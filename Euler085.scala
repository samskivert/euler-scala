object Euler085 extends EulerApp {
  def rects (n:Int, m:Int) = n*(n+1)*m*(m+1)/4
  val rs = for (x <- 1 to 99; y <- 1 to 99) yield (x*y, Math.abs(rects(x,y)-2000000))
  println(rs.sortBy(_._2).head._1)
}
