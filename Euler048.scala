object Euler048 extends EulerApp {
  def answer = (1 to 1000 map(a => BigInt(a).pow(a))).sum % BigInt(10).pow(10)
}
