object Euler060 extends EulerApp {
  val primes = genprimes(10000)
  val ppairs = Set() ++
  (for { ii <- 0 until primes.size-1; jj <- ii until primes.size
         pi = primes(ii); pj = primes(jj)
         if (isprime((pi.toString+pj).toInt) && isprime((pj.toString+pi).toInt)) }
   yield (pi, pj))

  def isset (pset :List[Int], prime :Int) =
    pset.foldLeft(true)((b, a) => b && ppairs((a, prime)))
  def find (pset :List[Int], plist :List[Int]) :Option[List[Int]] = {
    if (pset.size == 5) Some(pset)
    else if (plist.isEmpty) None
    else if (!isset(pset, plist.head)) find(pset, plist.tail)
    else find(plist.head :: pset, plist.tail).orElse(find(pset, plist.tail))
  }
  def answer = find(Nil, primes.toList).get.sum
}
