object Euler052 extends Application {
  def sort (n :Int) = n.toString.toList.sortWith(_<_).mkString.toInt
  def g (n :Int, sn :Int) = (2 to 6).forall(m => sort(n*m) == sn)
  def f (n :Int) = g(n, sort(n))
  println(Stream.from(1).find(f).get)
}
