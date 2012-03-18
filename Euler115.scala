object Euler115 extends EulerApp {
  def zpref (n :Int, way :List[Int]) :Boolean =
    if (n == 0 || (n == 1 && way.isEmpty)) true
    else !way.isEmpty && way.head == 0 && zpref(n-1, way.tail)
  def ones (n :Int, way :List[Int]) :List[Int] =
    if (n == 0) way
    else ones(n-1, 1 :: way)
  def grow (m :Int)(way :List[Int]) =
    if (way.head == 1) Seq(0 :: way, 1 :: way)
    else if (zpref(m, way)) Seq(0 :: way, ones(m, way.drop(m-1)))
    else Seq(0 :: way)
  def find (m :Int, n :Int, ways :Seq[List[Int]]) :Int =
    if (ways.length > 1000000) n
    else find(m, n+1, ways.flatMap(grow(m)))
  def answer = find(50, 1, Seq(List(0)))
}
