object Euler50 extends EulerApp {
  val pvec = genprimes(1000000);
  val primes = pvec.filter(0.!=);
  def lsum (idx :Int, sum :Int, length :Int, longest :Pair[Int,Int]) :Pair[Int,Int] = {
    val nsum = primes(idx) + sum;
    if (nsum > primes.last) longest;
    else if (nsum == primes.last) Pair(nsum, length+1);
    else if (pvec(nsum) != 0) lsum(idx+1, nsum, length+1, Pair(nsum, length+1));
    else lsum(idx+1, nsum, length+1, longest);
  }
  def longestsum (start :Int) = lsum(start, 0, 0, Pair(0, 0));
  def longer (a :Pair[Int,Int], b :Pair[Int,Int]) :Pair[Int,Int] = if (a._2 > b._2) a else b
  println(List.range(0, primes.length).map(longestsum).foldLeft(Pair(0, 0))(longer)._1);
}
