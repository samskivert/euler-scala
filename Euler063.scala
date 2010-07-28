object Euler063 extends EulerApp {
  def count (n :Int, p :Int, c :Int) :Int =
    if (n == 10) c
    else if (BigInt(n).pow(p).toString.length < p) count(n+1, 1, c)
    else count(n, p+1, c+1)
  println(count(1, 1, 0));
}
