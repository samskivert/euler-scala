object Euler82 extends EulerApp {
  val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt))
  def slice (m :Int) = List.range(0, matrix.length).map(n => matrix(n)(m))

  def cheapest (accum :List[Int], cur :List[Int]) = {
    (accum(0)+cur(0)) :: List.range(1, matrix.length).map(n => cur(n)+Math.min(accum(n), cur(n-1)))
  }

  def iter (accum :List[Int], cur :List[Int]) = {
    // println(accum)
    // println(cur)
    var across = accum.zip(cur).map(p => p._1+p._2)
    var down = across(0) :: List.range(1, across.length).map(n => Math.min(across(n-1)+cur(n), across(n)))
    List.range(0, across.length-1).map(n => Math.min(across(n+1)+cur(n), down(n))) ::: List(across.last)
  }

  var accum = slice(0)
  for (n <- 1 until matrix.length) {
    // println(accum)
    accum = iter(accum, slice(n))
  }
  println(accum.min)
}
