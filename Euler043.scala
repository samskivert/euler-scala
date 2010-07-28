object Euler43 extends Application {
  def compsum (n :Long, digits :List[Int], divs :List[Int], sum :Long) :Long = {
    if (digits.isEmpty) n + sum
    else (for { d <- digits; val nn = n*10 + d; if ((nn%1000) % divs.head == 0) }
          yield compsum(nn, digits-d, divs.tail, sum)).foldLeft(0L)(_+_)
  }
  def digits (n :Int) = n.toString.toList.map(_-'0')
  def norepeats (n :Int) = digits(n).removeDuplicates == digits(n)
  def compute (s :Int) = compsum(s, 0.to(9).toList -- digits(s), List(2, 3, 5, 7, 11, 13, 17), 0)
  println(100.to(999).filter(norepeats).map(compute).reduceLeft(_+_))
}
