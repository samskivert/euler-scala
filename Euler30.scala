object Euler30 extends Application {
  def digits (value :Int) :List[Int] = {
    if (value == 0) return Nil;
    else return (value % 10) :: digits(value/10);
  }

  println((for {
    value <- List.range(2, 200000)
    if (digits(value).map((a) => Math.pow(a, 5).intValue()).foldRight(0)(_+_) == value)
  } yield value).foldRight(0)(_+_));
}
