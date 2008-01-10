object Euler32 extends Application {
  def digits (value :Int) :List[Int] = {
    if (value == 0) return Nil;
    else return (value % 10) :: digits(value / 10);
  }
  def ispan (div :Int, mult :Int, value :Int) :Boolean = {
    return (digits(div) ::: digits(value) ::: digits(mult)).sort(_<_).equals(List.range(1,10));
  }
  def haspanfact (value :Int) :Boolean = {
    return List.range(2, 100).find(
      (div) => (value % div == 0 && ispan(div, value/div, value))) != None;
  }
  println(List.range(1000, 10000).filter(haspanfact).foldRight(0)(_+_));
}
