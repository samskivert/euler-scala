object Euler056 extends EulerApp {
  def answer = (for { a <- 90 to 100; b <- 90 to 100 }
                yield BigInt(a).pow(b).toString.map(_-'0').sum) max
}
