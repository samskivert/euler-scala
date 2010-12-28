object Euler107 extends EulerApp {
  def connected (matrix :List[Array[Int]]) = {
    val cmatrix = matrix.map(r => r.zipWithIndex map(c => if (c._1 == 0) 0 else c._2) toSet)
    def loop (node :Set[Int], seen :Set[Int]) :Set[Int] = {
      val reached = node -- seen
      ((seen ++ reached) /: reached)((nseen, v) => loop(cmatrix(v), nseen))
    }
    loop(cmatrix.head, Set(0)).size == matrix.size
  }
  def answer = {
    val network = readlines("network.txt") map(_.replace('-','0') split(",") map(_.toInt))
    val edges = network.zipWithIndex flatMap(
      r => r._1.zipWithIndex filter(c => c._1 != 0 && c._2 > r._2) map(c => (c._1, r._2, c._2)))
    var saved = 0
    for (e <- edges sortWith(_._1 > _._1)) {
      network(e._2)(e._3) = 0
      network(e._3)(e._2) = 0
      if (!connected(network)) {
        network(e._2)(e._3) = e._1
        network(e._3)(e._2) = e._1
      } else {
        saved += e._1
      }
    }
    saved
  }
}
