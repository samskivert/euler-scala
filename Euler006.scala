object Euler6 extends EulerApp {
  val first100sum = List.range(1,101).max
  val first100sumsq = List.range(1,101).foldLeft(0)((b, a) => (b + a*a))
  println(first100sum * first100sum - first100sumsq)
}
