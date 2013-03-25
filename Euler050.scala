object Euler050 extends EulerApp {
  case class PSum (sum :Int, length :Int) {
    def add (prime :Int) = PSum(sum+prime, length+1)
  }
  val pvec = genprimevec(1000000)
  val primes = pvec.filter(_ != 0)
  def fsum (idx :Int, csum :PSum, lsum :PSum) :PSum = {
    if (idx >= primes.length || csum.sum >= pvec.length) lsum
    else fsum(idx+1, csum.add(primes(idx)), if (pvec(csum.sum) != 0) csum else lsum)
  }
  def longer (one :PSum, two :PSum) = if (one.length > two.length) one else two
  def answer = 0.until(primes.length).map(fsum(_, PSum(0, 0), PSum(0, 0))).reduceLeft(longer).sum
}
