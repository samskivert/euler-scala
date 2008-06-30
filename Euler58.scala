object Euler58 extends EulerApp {
  def checkring (r :Int, primes :Int, nums :Int) :Int = {
    if (primes.toFloat/nums < 0.1) 2*r-1
    else {
      val skip = 2*r
      val base = (skip-1)*(skip-1)
      val rp = List(1, 2, 3).map(base+skip*_).filter(isprime).length
      checkring(r+1, primes+rp, nums+4);
    }
  }
  println(checkring(4, 8, 13));
}
