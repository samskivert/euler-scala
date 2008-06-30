object Euler69 extends EulerApp {
  println(genprimes(18).filter(0.!=).reduceLeft(_*_))
}
