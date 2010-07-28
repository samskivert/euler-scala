object Euler067 extends EulerApp {
  val tri = readlines("triangle.txt").map(_.split(" ").map(_.toInt).toList).reverse
  def fold (acc :List[Int], tri :List[List[Int]]) :Int = {
    if (acc.length == 1) acc(0)
    else fold(List.range(0, acc.length-1).map(i => tri.head(i) + Math.max(acc(i), acc(i+1))),
              tri.tail)
  }
  println(fold(tri.head, tri.tail))
}
