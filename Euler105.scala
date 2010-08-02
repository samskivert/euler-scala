object Euler105 extends EulerApp {
  def check (set :Array[Int]) = {
    def loop (i :Int, k :Int, used :Set[Int], sums :Map[Int,Set[Int]]) :Int = {
      if (i > set.length) set sum
      else if (k == 0) loop(i+1, i+1, used, sums)
      else {
        val nk = scala.collection.immutable.TreeSet[Int]() ++ sums(k-1).map(_+set(i-1))
        if ((nk & used).size > 0 || nk.head < sums(k-1).last ||
            nk.last > sums.getOrElse(k+1, Set(Int.MaxValue)).head) 0
        else loop(i, k-1, used ++ nk, sums + (k -> (nk ++ sums.getOrElse(k, Set[Int]()))))
      }
    }
    loop(1, 1, Set(), Map(0 -> Set(0)))
  }
//   def check (set :Array[Int]) :Int = {
//     var used = Set[Int]()
//     var sums = Map(0 -> Set(0))
//     for (i <- 1 to set.length; val n = set(i-1); k <- i to 1 by -1) {
//       val nk = scala.collection.immutable.TreeSet[Int]() ++ sums(k-1).map(_+n)
//       if ((nk & used).size > 0 || nk.head < sums(k-1).last ||
//           nk.last > sums.getOrElse(k+1, Set(Int.MaxValue)).head) return 0
//       else {
//         sums = sums + (k -> (nk ++ sums.getOrElse(k, Set[Int]())))
//         used = used ++ nk
//       }
//     }
//     set sum
//  }
  def answer = readlines("sets.txt") map(_ split(",") map(_.toInt) sortWith(_<_)) map(check) sum
}
