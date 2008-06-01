object Euler56 extends Application {
  def powsum (a :Int, b :Int) = BigInt(a).pow(b).toString.map(c => (c-'0')).foldLeft(0)(_+_);
  var sums = for { a <- List.range(90, 100); b <- List.range(90, 100) } yield powsum(a, b);
  println(sums.foldLeft(0)(Math.max));
}
