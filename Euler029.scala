object Euler029 extends EulerApp {
  def answer = (for (a <- 2 to 101; b <- 2 to 101)
                yield BigInt(a).pow(b)).distinct.length
}
