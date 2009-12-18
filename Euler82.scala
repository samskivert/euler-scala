object Euler82 extends EulerApp {
  val matrix = readlines("mmatrix.txt").map(_.split(",").map(_.toInt))
  def slice (m :Int) = List.range(0, matrix.length).map(n => matrix(n)(m)).toArray

  def iter (accum :Array[Int], cur :Array[Int]) = {
    var col = accum.zip(cur).map(p => p._1+p._2)
    println("1 -> " + col.toList)
    for (y <- 1 until col.length) {
      col(y) = Math.min(col(y), col(y-1)+col(y))
    }
    println("2 -> " + col.toList)
    for (y <- (col.length-2) until(0, -1)) {
      col(y) = Math.min(col(y), col(y+1)+col(y))
    }
    println("3 -> " + col.toList)
    col
  }

  var accum = slice(0)
  println(accum.toList)
  for (n <- 1 until matrix.length) {
    accum = iter(accum, slice(n))
  }
  println(accum.min)
}
