object Euler005 extends EulerApp {
  val divisors = List(20, 19, 18, 17, 16, 15, 14, 13, 12, 11)
  def check (value :Int) :Int = {
    if (divisors.exists((a) => (value % a != 0))) return check(20+value)
    else return value
  }
  def answer = check(20)
}
