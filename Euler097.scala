object Euler097 extends EulerApp {
  def answer = (BigInt(2).modPow(7830457, 10000000000L) * 28433 + 1) % 10000000000L
}
