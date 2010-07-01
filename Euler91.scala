object Euler91 extends EulerApp {
  def isright (ax :Int, ay :Int, bx :Int, by :Int) = {
    val ax2 = ax*ax
    val ay2 = ay*ay
    val bx2 = bx*bx
    val by2 = by*by
    val cx = ax-bx
    val cx2 = cx*cx
    val cy = ay-by
    val cy2 = cy*cy
    (ax2+ay2 == bx2+by2+cx2+cy2) || (bx2+by2 == ax2+ay2+cx2+cy2) || (cx2+cy2 == ax2+ay2+bx2+by2)
  }

  val size = 50
  val res = for (ay <- 1 to size; ax <- 0 to size;
                 by <- 0 to ay; bx <- math.max(ax,1) to size;
                 if ((ax!=bx || ay!=by) && isright(ax, ay, bx, by)))
            yield (ax, ay, bx, by)
  // res foreach (x => printf("+%d+%d, +%d+%d\n", x._1, x._2, x._3, x._4))
  println(res.length)
}
