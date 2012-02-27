object Euler067 extends EulerApp {
  val tri = readlines("triangle.txt").map(_.split(" ").map(_.toInt).toSeq).reverse
  def fold (acc :Seq[Int], tri :Seq[Seq[Int]]) :Int = {
    if (acc.length == 1) acc(0)
    else fold((0 until acc.length-1) map(i => tri.head(i) + math.max(acc(i), acc(i+1))), tri.tail)
  }
  def answer = fold(tri.head, tri.tail)
}
