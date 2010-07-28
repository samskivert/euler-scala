object Euler010 extends EulerApp {
  println(genprimes(2000000).foldLeft(0L)(_+_))
}
