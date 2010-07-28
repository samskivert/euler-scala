object Euler078 extends EulerApp {
  def part_mod (n :Int, parts :Array[Int]) = {
    var sign = 1
    for (k <- 1 to Math.sqrt(n)) {
      val n1 = k * (3*k - 1) / 2
      if (n1 <= n) {
        parts(n) = (parts(n) + sign * parts(n-n1))
        val n2 = k * (3*k + 1) / 2
        if (n2 <= n) parts(n) = (parts(n) + sign * parts(n-n2))
      }
      sign = -sign
    }
    parts(n) %= 1000000
    parts(n) == 0
  }
  val parts = Array.make(100000, 0)
  parts(0) = 1
  println(Iterator.from(1).find(part_mod(_, parts)).get)
}
