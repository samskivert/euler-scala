object Euler56 extends EulerApp {
  def powsum (a :Int, b :Int) = BigInt(a).pow(b).toString.map(c => (c-'0')).sum;
  var sums = for { a <- List.range(90, 100); b <- List.range(90, 100) } yield powsum(a, b);
  println(sums.max);
}
