import scala.collection.immutable.TreeSet
object Euler83 extends EulerApp {
  val deltas = List((-1,0),(0,-1),(1,0),(0,1))
  val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt)).toArray
  val costs = Array.fill(matrix.length, matrix.length)(Int.MaxValue)
  costs(0)(0) = matrix(0)(0)
  var nodes = TreeSet((costs(0)(0), 0, 0))
  while (!nodes.isEmpty) {
    val node = nodes.head
    nodes -= node
    for ((nx, ny) <- deltas.map(p => (node._2+p._1, node._3+p._2))) {
      if (ny >= 0 && ny < matrix.length && nx >= 0 && nx < matrix.length) {
        val nc = node._1 + matrix(ny)(nx)
        val cc = costs(ny)(nx)
        if (cc > nc) {
          nodes -= Tuple3(cc, nx, ny)
          costs(ny)(nx) = nc
          nodes += Tuple3(nc, nx, ny)
        }
      }
    }
  }
  println(costs.last.last)
}
