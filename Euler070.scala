object Euler070 extends EulerApp {
  val range = (math.sqrt(10000000)/2).toInt
  val primes = genprimevec(3*range).filter(range < _)
  val nums = for {
    p1 <- primes; p2 <- primes.dropWhile(_ == p1)
    n = p1*p2; phi = (p1-1)*(p2-1)
    if (n < 10000000 && n.toString.sortWith(_<_) == phi.toString.sortWith(_<_))
  } yield (n, n.toFloat/phi)
  def answer = nums.reduceLeft((a, b) => if (a._2 < b._2) a else b)._1
}
