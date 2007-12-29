object Euler1 extends Application {
  def div3or5 (from: Int, to: Int): List[Int] = {
    for (i <- List.range(from, to) if i % 3 == 0 || i % 5 == 0) yield i
  }
  def sum (values :List[Int]) = {
    values.foldLeft(0)((b, a) => (b + a))
  }
  println(sum(div3or5(0, 1000)))
}
