object Euler100 extends EulerApp {
  val SQRT2 = math.sqrt(2)
  val START = 1000000000000L
  def check (n :Long) :Long = {
    val b = math.ceil(n / SQRT2).toLong
    if (BigInt(n) * (n-1) == BigInt(b) * (b-1) * 2) {
      if (BigInt(n) > BigInt(START)) b
      else check((5.828427*n).toLong)
    } else check(n+1)
  }
  def answer = check(1)
}
