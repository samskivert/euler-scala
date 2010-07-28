object Euler81 extends EulerApp {
  val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt))
  for (y <- 1 until matrix.length) matrix(y)(0) += matrix(y-1)(0)
  for (x <- 1 until matrix.length) matrix(0)(x) += matrix(0)(x-1)
  for (y <- 1 until matrix.length; x <- 1 until matrix.length)
    matrix(y)(x) += Math.min(matrix(y-1)(x), matrix(y)(x-1))
  println(matrix.last.last)
}
