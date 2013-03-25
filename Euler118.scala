object Euler118 extends EulerApp {
  type BD = (Int,Int)
  // generates list of (bits, digs) for all primes without repeating digits
  // bits has 1 in every bit where the prime has a digit, digs is the count of digits
  val primes = {
    def tup (ps :List[BD], px :Int, bits :Int, digs :Int) :List[BD] = {
      if (px == 0) (bits, digs) :: ps
      else {
        val bit = 1 << (px % 10 - 1)
        if ((bits & bit) != 0) ps
        else tup(ps, px/10, bits | bit, digs+1)
      }
    }
    // we know there are no nine digit primes that meet our criteria, so we cheat here
    // (not cheating would mean generating all primes <= 987654321, but this primegen part is 99%
    // of the runtime of this algorithm, and we're already too close to the 60s limit)
    foldprimes(98765432, List[BD]())((ps, p) => tup(ps, p, 0, 0)).reverse
  }
  def answer = {
    def cprimes (ps :List[BD], curbits :Int, curpop :Int) :Int = {
      def iter (ps :List[BD], count :Int) :Int = ps match {
        case Nil => count
        case (bits, pop) :: t =>
          // pop is mon. increasing; if this prime pushes us over 9 digits, so will all the rest
          if (pop + curpop > 9) count
          // if this prime uses already used digits, skip to the next one
          else if ((bits & curbits) != 0) iter(t, count)
          // otherwise recurse with this prime added to our set (cprimes call), and keep looking
          // for other primes that also work in the current position (iter call)
          else iter(t, count + cprimes(t, bits | curbits, pop + curpop))
      }
      // if curbits is 0b111111111 then we have all nine digits, which is a match
      if (curbits == 0x1FF) 1 else iter(ps, 0)
    }
    cprimes(primes, 0, 0)
  }
}
