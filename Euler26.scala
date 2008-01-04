object Euler26 extends Application {
  def divcycle (numer :Int, denom :Int, digits :List[Int], rlist :List[Int]) :Int = {
    if (denom > numer) {
      return divcycle(numer * 10, denom, 0 :: digits, 0 :: rlist);
    }
    val remain = numer % denom;
    if (remain == 0) {
      return 0;
    }
    val ridx = rlist.indexOf(remain);
    if (ridx >= 0) {
      return (ridx+1);
    }
    return divcycle(remain * 10, denom, numer / denom :: digits, remain :: rlist);
  }

  var cycles = List.range(1, 1000).map((v) => divcycle(1, v, Nil, Nil));
  println(cycles.indexOf(cycles.foldRight(0)((a, v) => (if (a > v) a else v)))+1);
}
