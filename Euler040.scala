object Euler040 extends EulerApp {
  val digits = (1 until 200000).flatMap(_.toString.map(_-'0'))
  def answer = (0 until 6).foldRight(1)((idx, b) => b * digits(math.pow(10, idx).intValue-1))
}
