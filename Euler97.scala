object Euler97 extends EulerApp {
  println((BigInt(2).modPow(7830457, 10000000000L) * 28433 + 1) % 10000000000L)
}
