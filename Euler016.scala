object Euler016 extends EulerApp {
  def answer = BigInt(2).pow(1000).toString.foldRight(0)((a, b) => (b + (a - '0')))
}
