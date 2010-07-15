object Euler94 {
  val MAX = 1000000000L/3
  def check (a :Long, b :Long) = {
    val area = b * math.sqrt(a*a - b*b)
    if (area == area.toLong) 2*a+2*b else 0
  }
  def scan (a :Long, accum :Long) :Long = {
    if (a > MAX) accum
    else scan(a+2, accum + check(a, (a-1)/2) + check(a, (a+1)/2))
  }
  def main (args :Array[String]) {
    println(scan(3, 0))
  }
}
