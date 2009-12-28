object Euler87 extends EulerApp {
  val limit = 50000000
  val primes = genprimes(2*Math.sqrt(limit).toInt).filter(_!=0).toArray
  def f (a :Int, b :Int, c :Int) = a*a + b*b*b + c*c*c*c
  def count (cnt :Int, ai :Int, bi :Int, ci :Int) :Int =
    if (f(primes(ai), primes(bi), primes(ci)) < limit) count(cnt+1, ai+1, bi, ci)
    else if (f(primes(0), primes(bi+1), primes(ci)) < limit) count(cnt+1, 1, bi+1, ci)
    else if (f(primes(0), primes(0), primes(ci+1)) < limit) count(cnt+1, 1, 0, ci+1)
    else cnt
  println(count(0, 0, 0, 0))
}
