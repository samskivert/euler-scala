object Euler036 extends Application {
  def ispal (n :String) = n.reverse.sameElements(n)
  def bothpal (n :Int) = ispal(n.toString) && ispal(n.toBinaryString)
  println(List.range(1, 1000000, 2).filter(bothpal).foldRight(0)(_+_));
}
