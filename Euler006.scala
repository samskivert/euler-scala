object Euler006 extends EulerApp {
  val first100sum = List.range(1,101).sum
  val first100sumsq = List.range(1,101).foldLeft(0)((b, a) => (b + a*a))
  def answer = first100sum * first100sum - first100sumsq
}
