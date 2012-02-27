object Euler083 extends EulerApp {
  def min4 (a :Int, b :Int, c :Int, d :Int) = math.min(math.min(a, b), math.min(c, d))
  val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt)).toArray
  val cs = Array.fill(matrix.length+2, matrix.length+2)(Int.MaxValue)
  cs(1)(0) = 0
  for (i <- 0 until 4; y <- 0 until matrix.length; x <- 0 until matrix.length)
    cs(y+1)(x+1) = matrix(y)(x) + min4(cs(y+2)(x+1), cs(y)(x+1), cs(y+1)(x), cs(y+1)(x+2))
  def answer = cs(matrix.length)(matrix.length)
}
