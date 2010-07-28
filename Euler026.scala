object Euler026 extends Application {
  def divcycle (numer :Int, denom :Int, rlist :List[Int]) :Int = {
    val remain = numer % denom;
    if (remain == 0) return 0;
    val ridx = rlist.indexOf(remain);
    if (ridx >= 0) ridx+1 else divcycle(remain * 10, denom, remain :: rlist);
  }
  var cycles = List.range(1, 1000).map(v => divcycle(1, v, Nil));
  println(cycles.indexOf(cycles.foldRight(0)(Math.max))+1);
}
