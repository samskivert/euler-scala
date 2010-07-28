object Euler094 extends EulerApp {
  val MAX = 1000000000L/3
  def check (a :Double, b :Double) :Long = {
    val area = b * math.sqrt(a*a - b*b)
    if (area == area.toLong) (2*a+2*b).toLong
    else 0
  }
  def scan (a :Long, accum :Long) :Long = {
    if (a > MAX) accum
    else scan(a+1, accum + check(a, (a-1)/2.0) + check(a, (a+1)/2.0))
  }
  def answer = scan(3, 0)
}
