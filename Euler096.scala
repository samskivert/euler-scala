object Euler096 extends EulerApp {
  def itor (i :Int) = i/9
  def itoc (i :Int) = i%9
  def itos (i :Int) = (itoc(i)/3)*3 + itor(i)/3

  def row (p :Seq[Set[Int]], r :Int, i :Int) =
    (p slice(9*r, i)) ++ (p slice(i+1, 9*r+9))
  def col (p :Seq[Set[Int]], c :Int, i :Int) =
    (List() ++ (c until p.size by 9) filterNot(_ == i)) map(p)
  def sect (p :Seq[Set[Int]], s :Int, i :Int) =
    (p zipWithIndex) filter(e => itos(e._2) == s && e._2 != i) map(_._1)

  def known (group :Seq[Set[Int]]) = Set() ++ group filter(_.size == 1) flatten
  def count (p :Seq[Set[Int]], v :Int) = (0 /: p) ((c, s) => if (s(v)) c+1 else c)

  def reduce (g :Array[Set[Int]]) :Array[Set[Int]] = {
    var reduced = 0
    for (i <- 0 until 81; if g(i).size > 1) {
      val r = row(g, itor(i), i)
      val c = col(g, itoc(i), i)
      val s = sect(g, itos(i), i)
      var ng = g(i) -- (known(r) ++ known(c) ++ known(s))
      if (ng.size > 1) {
        for (v <- ng; if (count(r, v) == 0 || count(c, v) == 0 || count(s, v) == 0)) {
          ng = Set(v)
        }
      }
      reduced += g(i).size - ng.size
      g(i) = ng
    }
    if (reduced == 0) g else reduce(g)
  }

  def isComplete (g :Array[Set[Int]]) = (g map(_.size) sum) == 81
  def explore (g :Array[Set[Int]], i :Int, v :Int) = { g(i) = g(i) - v; reduce(g) }
  def guess (g :Array[Set[Int]]) = if (isComplete(g)) g else
    (for (i <- 0 until g.length; if (g(i).size > 1); v <- g(i);
          ng = explore(g.clone, i, v); if (isComplete(ng))) yield ng).head

  def toGrid (p :String) = p map(c => if (c == '0') 1 to 9 toSet else Set(c - '0')) toArray
  val puzzles = readlines("sudoku.txt") grouped(10) map(_.tail.mkString) map(toGrid)
  def answer = puzzles map(p => guess(reduce(p)).take(3).toList.flatten.mkString.toInt) sum
}
