object Euler066 extends EulerApp {
  val maxx = Math.sqrt(Math.MAX_LONG).toLong
  println("MAX " + maxx)
  def solve (d :Int, x :Int) :Pair[Int,Int] = {
    val x2 = x.toLong * x;
    val y = Math.sqrt((x2 - 1) / d).toInt
    if (x > 30370004) (0, 0)
    else if (x2 - y.toLong*y*d == 1) (x, y)
    else solve(d, x+1)
  }
  def notsquare (x :Int) = (Math.sqrt(x.toDouble) - Math.sqrt(x)) > 0
  for (d <- 2.to(100).filter(notsquare)) {
    println(d + " -> " + solve(d, 2))
  }
}
