object Euler091 extends EulerApp {
  def isright (ax :Int, ay :Int, bx :Int, by :Int) = {
    val (cx, cy) = (ax-bx, ay-by)
    val (ax2, bx2, cx2, ay2, by2, cy2) = (ax*ax, bx*bx, cx*cx, ay*ay, by*by, cy*cy)
    (ax2+ay2 == bx2+by2+cx2+cy2) || (bx2+by2 == ax2+ay2+cx2+cy2) || (cx2+cy2 == ax2+ay2+bx2+by2)
  }
  val SIZE = 50
  def answer = (for (ay <- 1 to SIZE; ax <- 0 to SIZE;
                     by <- 0 to ay; bx <- math.max(ax,1) to SIZE;
                     if ((ax!=bx || ay!=by) && isright(ax, ay, bx, by))) yield true).length
}
