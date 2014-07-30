object Euler026s extends EulerApp {
  def divcycle (numer :Int, denom :Int, rlist :List[Int]) :Int = {
    val remain = numer % denom
    if (remain == 0) return 0
    val ridx = rlist.indexOf(remain)
    if (ridx >= 0) ridx+1 else divcycle(remain * 10, denom, remain :: rlist)
  }
  var cycles = (1 until 1000).map(divcycle(1, _, Nil))
  def answer = cycles.indexOf(cycles.max)+1
}
