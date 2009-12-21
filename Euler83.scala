object Euler83 extends EulerApp {
  private var _iter :Int = 0
  def print (matrix :Array[Array[Int]]) {
    for (y <- 0 until matrix.length) {
      for (x <- 0 until matrix.length) {
        printf("%4d ", matrix(y)(x))
      }
      println("")
    }
  }
  def search (matrix :Array[Array[Int]], cost :Array[Array[Int]], x :Int, y :Int, nc :Int) {
    val c = cost(y)(x)
    if (c != 0 && nc >= c) {
      return
    }
    if (c != 0) {
      println("Lowering " + x + "/" + y + " to " + nc + " from " + c)
    }
    cost(y)(x) = nc
    _iter += 1
    if (x > 0) search(matrix, cost, x-1, y, nc + matrix(y)(x-1))
    if (y > 0) search(matrix, cost, x, y-1, nc + matrix(y-1)(x))
    if (x < matrix.length-1) search(matrix, cost, x+1, y, nc + matrix(y)(x+1))
    if (y < matrix.length-1) search(matrix, cost, x, y+1, nc + matrix(y+1)(x))
  }
  val matrix = readlines("mmatrix.txt").map(_.split(",").map(_.toInt)).toArray
  val cost = Array.ofDim[Int](matrix.length, matrix.length)
  search(matrix, cost, 0, 0, matrix(0)(0))
  print(cost)
  println(cost.last.last)
  println(_iter)
}
