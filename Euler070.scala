object Euler070 extends EulerApp {
  val range = Math.sqrt(10000000)/2
  val primes = genprimes(3*range).filter(range.<)
  val nums = for {
    p1 <- primes; p2 <- primes.dropWhile(p1.==)
    val n = p1*p2
    val phi = (p1-1)*(p2-1)
    if (n < 10000000 && n.toString.toList.sort(_<_) == phi.toString.toList.sort(_<_))
  } yield (n, n.toFloat/phi)
  println(nums.reduceLeft((a, b) => if (a._2 < b._2) a else b)._1)
}
