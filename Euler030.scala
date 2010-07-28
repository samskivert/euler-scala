object Euler30 extends Application {
  def digits (n :Int) = n.toString.toList.map(c => c - '0');
  def issum5 (n :Int) = digits(n).map(a => Math.pow(a, 5).intValue()).foldRight(0)(_+_) == n;
  println(List.range(2, 200000).filter(issum5).foldRight(0)(_+_));
}
