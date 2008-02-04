object Euler27 extends EulerApp {
  val MAX_N = 80;
  val primes = genprimes(MAX_N*MAX_N + MAX_N*1000 + 1000);
  def polyprimes (primes :Array[Int], a :Int, b :Int, n :Int) :Int =
    if (primes(Math.abs(n*n + a*n + b)) == 0) 0 else 1 + polyprimes(primes, a, b, n+1);

  val polys = for {
    a <- List.range(-1000, 1000)
    b <- List.range(-1000, 1000)
    p <- List(polyprimes(primes, a, b, 0))
    if (p > 0)
  } yield Pair(a * b, p);
  println(polys.foldLeft(Pair(0, 0))((a, b) => if (a._2 > b._2) a else b)._1);
}
