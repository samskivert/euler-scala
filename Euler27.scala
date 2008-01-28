object Euler27 extends EulerApp {
  val MAX_N = 80;
  val primes = genprimes(MAX_N*MAX_N + MAX_N*1000 + 1000);

  def polyprimes (a :Int, b :Int, n :Int) :Int = {
    val r = Math.abs(n*n + a*n + b);
    if (primes(r) == 0) {
      return 0;
    } else {
      return 1 + polyprimes(a, b, n+1);
    }
  }

  val polys = for {
    a <- List.range(-1000, 1000)
    b <- List.range(-1000, 1000)
    p <- List(polyprimes(a, b, 0))
    if (p > 0)
  } yield Pair(a * b, p);
  println(polys.foldLeft(Pair(0, 0))((a, b) => if (a._2 > b._2) a else b)._1);
}
