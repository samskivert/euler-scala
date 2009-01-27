object Euler76 extends EulerApp {
  val smap = new scala.collection.mutable.HashMap[Pair[Int, Int],Int]
  def sums (n :Int, max :Int) :Int = smap.getOrElseUpdate((n, max), {
    (if (n <= max) 1 else 0) + 1.to(n-1).filter(max.>=).map(k => sums(n-k, k)).sum
  })
  println(sums(100, 99))

//   val parts = new scala.collection.mutable.HashMap[Int,Int]
//   parts(0) = 1
//   def part (n :Int) :Int = if (n < 0) 0 else parts.getOrElseUpdate(n, {
//     def parth (k :Int) = {
//       val n1 = n - k * (3 * k - 1) / 2
//       val n2 = n - k * (3 * k + 1) / 2
//       val Pn1 = part(n1)
//       val Pn2 = part(n2)
//       if (k % 2 == 1) Pn1 + Pn2 else -Pn1 - Pn2
//     }
//     1.to(Math.sqrt(n)).map(parth).sum
//   })
//   println(part(100)-1)
}
