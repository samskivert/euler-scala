object Euler031 extends EulerApp {
  def perms (remain :Int, coins :List[Int]) :Int =
    if (remain == 0) 1 else coins match {
      case Nil => 0
      case h::t => 0 to (remain/h) map(q => perms(remain - q*h, t)) sum
    }
  def answer = perms(200, List(200, 100, 50, 20, 10, 5, 2, 1))
}
