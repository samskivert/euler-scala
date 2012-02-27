object Euler089 extends EulerApp {
  val R2D = Map('I'->1, 'V'->5, 'X'->10, 'L'->50, 'C'->100, 'D'->500, 'M'->1000)
  def fold (v :List[Int], last :Int, sum :Int) :Int = v match {
    case Nil => sum
    case h::t => fold(t, h, if (h >= last) sum+h else sum-h)
  }
  def r2d (v :String) = fold(v.reverse map R2D toList, 0, 0)
  val D2R = List("M"->1000, "CM"->900, "D"->500, "CD"->400, "C"->100, "XC"->90,
                 "L"->50, "XL"->40, "X"->10, "IX"->9, "V"->5, "IV"->4, "I"->1)
  def d2r (n :Int, ts :List[Pair[String,Int]] = D2R) :String = ts match {
    case Nil => ""
    case h::t => if (n >= h._2) h._1 + d2r(n-h._2, ts) else d2r(n, t)
  }
  def answer = readlines("roman.txt") map(s => s.length - d2r(r2d(s)).length) sum
}
