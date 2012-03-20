object Euler114 extends EulerApp {
  def loop (n :Int, z0 :Long, z1 :Long, z2 :Long, z3 :Long) :Long =
    if (n == 50) z0 + z1 + z2 + z3
    else loop(n+1, z0 + z3, z0, z1, z2 + z3)
  def answer = loop(3, 1, 0, 0, 1)
}
