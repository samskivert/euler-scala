object Euler78 extends EulerApp {
  val parts = Array.make(1000000, BigInt(0))
  parts(0) = 1
  def part (n :Int) :BigInt = {
    if (n < 0) 0
    else if (parts(n) > 0) parts(n)
    else {
      var pn = BigInt(0)
      for (k <- 1.to(Math.sqrt(n))) {
        val p1 = part(n - k * (3*k - 1) / 2)
        val p2 = part(n - k * (3*k + 1) / 2)
        if (k % 2 == 1) pn = pn + p1 + p2
        else pn = pn - p1 - p2
      }
      parts(n) = pn
      pn
    }
  }

  var n = 0
  while ((part(n) % 1000000) != 0) {
    n = n + 1
    if (n % 100 == 0) {
      println(n + " -> " + part(n))
    }
  }
  println(n)

//   for (n <- 1.to(500)) {
//     println(n + " -> " + part(n))
//   }
}
