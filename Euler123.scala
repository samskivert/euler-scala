object Euler123 extends EulerApp {
  def answer = {
    val ps = genprimes(10000000)
    // (p-1)^n+(p+1)^n mod p^2 is 2*n*p for odd p (and 2 for even p)
    def loop (n :Int) :Int = if (2*n*ps(n-1).toLong > 10000000000L) n else loop(n+2)
    loop(7037)
  }
}
