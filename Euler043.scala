object Euler043 extends EulerApp {
  def digits (n :Int) = n.toString.toList.map(_-'0')
  def compsum (n :Long, digits :Set[Int], divs :List[Int], sum :Long) :Long = {
    if (digits.isEmpty) n + sum
    else (for (d <- digits; nn = n*10 + d; if ((nn%1000) % divs.head == 0))
          yield compsum(nn, digits filterNot(_ == d), divs.tail, sum)).sum
  }
  def compute (s :Int) = compsum(s, (0 to 9).toSet -- digits(s), List(2, 3, 5, 7, 11, 13, 17), 0)
  def answer = 100 to 999 filter(n => digits(n).distinct == digits(n)) map(compute) sum
}
