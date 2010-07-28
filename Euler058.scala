object Euler058 extends EulerApp {
  def checkring (r :Int, primes :Int, nums :Int) :Int = {
    if (primes*10/nums < 1) 2*r-1
    else {
      val skip = 2*r
      val base = (skip-1)*(skip-1)
      val rp = List(1, 2, 3).map(base+skip*_).filter(isprime).length
      checkring(r+1, primes+rp, nums+4);
    }
  }
  def answer = checkring(2, 3, 5)
}
