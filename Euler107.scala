object Euler107 extends EulerApp {
  def connected (matrix :List[Array[Int]]) = {
    def loop (node :Array[Int], seen :Set[Int]) :Set[Int] = {
      val reached = (node.zipWithIndex filter(_._1 != 0) map(_._2) toSet) -- seen
      if (reached.isEmpty) seen
      else reached flatMap(v => loop(matrix(v), seen ++ reached))
    }
    loop(matrix.head, Set(0)).size == matrix.size
  }
  val network = readlines("network.txt") map(_ split(",") map(_.toInt))
  val edges = network.zipWithIndex flatMap(
    r => r._1.zipWithIndex filter(c => c._1 != 0 && c._2 > r._2) map(c => (c._1, r._2, c._2)))
  def answer = {
    val osum = edges map(_._1) sum
    var nsum = osum
    for (e <- edges sortWith(_._1 > _._1)) {
      network(e._2)(e._3) = 0
      network(e._3)(e._2) = 0
      if (!connected(network)) {
        network(e._2)(e._3) = e._1
        network(e._3)(e._2) = e._1
      } else {
        nsum -= e._1
      }
    }
    osum - nsum
  }
}
