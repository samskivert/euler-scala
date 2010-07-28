object Euler047 extends Application {
  val factors = Array.make(150000, 0)
  var idx = 2
  while (idx < factors.length) {
    for (midx <- List.range(idx+idx, factors.length, idx)) factors(midx) += 1
    do idx = idx+1
    while (idx < factors.length && factors(idx) != 0)
  }
  println(1.to(factors.length-3).find(n => factors.slice(n, n+4).mkString == "4444"))
}
