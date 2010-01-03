object Euler90 extends EulerApp {
  def augment (cube :Set[Int]) = if (cube(6)) cube+9 else if (cube(9)) cube+6 else cube
  def mkcubes (from :Seq[Int], s :Int, n :Int) :Seq[Set[Int]] = {
    if (n == 0) List(augment(from toSet))
    else s to 9 flatMap(d => mkcubes(from filter d.!=, Math.max(d, s)+1, n-1))
  }
  def valid (c1 :Set[Int], c2 :Set[Int]) =
    1 to 9 map(n => n*n) forall(n => c1(n/10) && c2(n%10) || c2(n/10) && c1(n%10))
  val cubes = mkcubes(0 to 9, 0, 4)
  println((for (c1 <- cubes; c2 <- cubes; if valid(c1, c2)) yield 1).sum / 2)
}
