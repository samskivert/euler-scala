object Euler1 extends Application {
  def div3or5 (from: Int, to: Int): List[Int] = {
    for (i <- List.range(from, to) if i % 3 == 0 || i % 5 == 0) yield i
  }
  println(div3or5(0, 1000).foldLeft(0)(_+_))
}
