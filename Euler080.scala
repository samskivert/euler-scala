object Euler080 extends EulerApp {
  def f (p :BigInt, x :Int) = (p*20 + x) * x
  def maxx (c :BigInt, p :BigInt, x :Int) :Int = if (f(p, x) > c) x-1 else maxx(c, p, x+1)
  def root (c :BigInt, p :BigInt, acc :Int, iter :Int) :Int = {
    val x = maxx(c, p, 1)
    val y = f(p, x)
    if (y == c) 0
    else if (iter == 99) acc+x
    else root((c - y) * 100, p*10 + x, acc+x, iter+1)
  }
  def answer = (2 to 100).map(n => root(n, 0, 0, 0)).sum
}
