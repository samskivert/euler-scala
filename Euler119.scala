object Euler119 extends EulerApp {
  def sumdigs (a :BigInt) = a.toString map(_ - '0') sum
  val as = for (n <- 2 to 100; p <- 2 to 10; a = BigInt(n) pow p; if (sumdigs(a) == n)) yield a
  def answer = as.sorted apply 29
}
