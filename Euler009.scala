object Euler009 extends EulerApp {
  def answer = (for {
    a <- (1 until 1000)
    b <- (a until 1000)
    c <- (b until 1000)
    if (a*a + b*b == c*c && a+b+c == 1000)
  } yield a*b*c).head
}
