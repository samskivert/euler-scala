object Euler090 extends EulerApp {
  def augment (cube :Set[Int]) = if (cube(6) || cube(9)) cube+6+9 else cube
  val cubes = for (a <- 0 to 9; b <- a+1 to 9; c <- b+1 to 9; d <- c+1 to 9;
                   e <- d+1 to 9; f <- e+1 to 9) yield augment(Set(a, b, c, d, e, f))
  def valid (c1 :Set[Int], c2 :Set[Int]) =
    1 to 9 map(n => n*n) forall(n => c1(n/10) && c2(n%10) || c2(n/10) && c1(n%10))
  def answer = (for (c1 <- cubes; c2 <- cubes; if valid(c1, c2)) yield true).length / 2
}
