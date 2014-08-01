object Euler123 extends EulerApp {
  def answer = {
    val M = 10000000000L
    val ps = genprimes(10000000)
    def loop (n :Int) :Int = {
      val p = ps(n-1) ; val p2 = p.toLong*p
      def mpow (b :Long, exp :Long, acc :Long) :Long =
        if (exp == 0) acc else mpow(b, exp-1, (acc * b) % p2)
      if (p2 > M && (mpow(p-1, n, 1) + mpow(p+1, n, 1)) % p2 > M) n
      else loop(n+2)
    }
    loop(7037)
  }
}
