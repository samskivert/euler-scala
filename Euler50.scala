object Euler50 extends EulerApp {
  val pvec = genprimes(1000000)
  val primes = pvec.filter(0.!=)
  def lsum (idx :Int, sum :Int, length :Int, longest :Pair[Int,Int]) :Pair[Int,Int] = {
    val nsum = primes(idx) + sum
    if (nsum > primes.last) longest
    else if (nsum == primes.last) Pair(nsum, length+1)
    else if (pvec(nsum) != 0) lsum(idx+1, nsum, length+1, Pair(nsum, length+1))
    else lsum(idx+1, nsum, length+1, longest)
  }
  def longer (a :Pair[Int,Int], b :Pair[Int,Int]) = if (a._2 > b._2) a else b
  println(0.until(primes.length).map(lsum(_, 0, 0, Pair(0, 0))).reduceLeft(longer)._1)
}
