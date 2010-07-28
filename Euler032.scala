object Euler32 extends Application {
  def digits (n :Int) = n.toString.toList.map(c => c - '0');
  def ispan (a :Int, b :Int, n :Int) :Boolean =
    (digits(a) ::: digits(n) ::: digits(b)).sort(_<_).equals(List.range(1,10));
  def haspanfact (n :Int) :Boolean =
    List.range(2, 100).find((a) => (n % a == 0 && ispan(a, n/a, n))) != None;
  println(List.range(1000, 10000).filter(haspanfact).foldRight(0)(_+_));
}
