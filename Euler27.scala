object Euler27 extends Application {
  val MAX_N = 80;

  var primes = List.range(0,MAX_N*MAX_N + MAX_N*1000 + 1000).toArray;
  var idx = 2;
  while (idx >= 0) {
    var prime = primes(idx);
    var midx = idx + prime;
    while (midx < primes.length) {
      primes(midx) = 0;
      midx += prime;
    }
    val nidx = primes.slice(idx+1, primes.length).findIndexOf((a) => (a != 0));
    if (nidx == -1) idx = -1 else idx = idx + 1 + nidx;
  }

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
