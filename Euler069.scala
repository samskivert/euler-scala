object Euler069 extends EulerApp {
  def answer = genprimes(18).reduceLeft(_*_)
}
