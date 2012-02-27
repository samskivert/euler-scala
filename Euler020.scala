object Euler020 extends EulerApp {
  def fact (n: BigInt): BigInt = if (n == 0) 1 else n * fact(n - 1)
  def answer = fact(100).toString().foldRight(0)((a, b) => (b + (a - '0')))
}
