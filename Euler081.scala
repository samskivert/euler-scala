object Euler081 extends EulerApp {
  def answer = {
    val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt))
    for (y <- 1 until matrix.length) matrix(y)(0) += matrix(y-1)(0)
    for (x <- 1 until matrix.length) matrix(0)(x) += matrix(0)(x-1)
    for (y <- 1 until matrix.length; x <- 1 until matrix.length)
      matrix(y)(x) += math.min(matrix(y-1)(x), matrix(y)(x-1))
    matrix.last.last
  }
}
