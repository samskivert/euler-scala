object Euler103 extends EulerApp {
  def answer = 20 :: List(11, 18, 19, 20, 22, 25).map(_ + 20) mkString

//   def osss (n :Int) :List[Int] =
//     if (n == 1) 1 :: Nil else if (n == 6) List(11, 18, 19, 20, 22, 25) else {
//       val ps = List(11, 18, 19, 20, 22, 25)
//       val el = ps.drop(ps.length/2).head
//       el +: ps.map(_ + el)
//     }

//   def powset (set :Set[Int]) = {
//     def expand (set :Set[Int], extra :Set[Int]) :List[Set[Int]] =
//       List(set) ++ extra.flatMap(i => expand(set + i, extra - i))
//     set flatMap(i => expand(Set(i), set - i)) toList
//   }

//   def valid (set :Set[Int]) = {
//     val pset = powset(set)
//     for (e1 <- pset; e2 <- pset; if ((e1 & e2).isEmpty)) {
//       val e1s = e1.sum
//       val e2s = e2.sum
//       if (e1s == e2s) println(e1 + " sum= " + e2)
//       else if (e1.size > e2.size && !(e1s > e2s))
//         println(e1 + " > " + e2 + " but " + e1.sum + " !> " + e2.sum)
//       else if (e1.size < e2.size && !(e1s < e2s))
//         println(e1 + " < " + e2 + " but " + e1.sum + " !< " + e2.sum)
//     }
//     (for (e1 <- pset; e2 <- pset; if ((e1 & e2).isEmpty); val e1s = e1.sum; val e2s = e2.sum)
//      yield (e1s != e2s) && (e1.size <= e2.size || e1s > e2s) &&
//            (e2.size <= e1.size || e2s > e1s)) forall(x => x)
//   }

//   def search (size :Int, cur :Int, bound :Int, set :List[Int], sums :Map[Int,Set[Int]], used :Set[Int]) :Seq[List[Int]] = {
//     if (set.sum > 255) Nil
//     else if (set.size == size) { println(set + " (" + set.sum + ") -> " + valid(set toSet)) ; List(set) }
//     else {
//       cur to (bound-size+set.length) flatMap(n => {
//         if (set.size == 0) println("Scanning " + n + "...")
//         // println("Expanding " + set + " with " + n)
//         val nbound = if (set.size == 1) (set.head+n) else bound
//         val nset = set :+ n
//         var nsums = sums
//         var nused = used
//         var conflict = false
//         for (k <- nset.length to 1 by -1) {
//           val nk = scala.collection.immutable.TreeSet[Int]() ++ sums(k-1).map(_+n)
//           if ((nk & used).size > 0) {
//             // println("*** overlap " + nk + " -> " + (nk & used))
//             conflict = true
//           } else if (nk.head < sums(k-1).last) {
//             // println("*** " + nk + " < " + sums(k-1))
//             conflict = true
//           } else if (nk.last > sums.getOrElse(k+1, Set(Int.MaxValue)).head) {
//             // println("*** " + nk + " > " + sums.getOrElse(k+1, Set(Int.MaxValue)))
//             conflict = true
//           } else {
//             nsums = nsums + (k -> (sums.getOrElse(k, scala.collection.immutable.TreeSet[Int]()) ++ nk))
//             nused = nused ++ nk
//           }
//         }
//         if (conflict) Nil
//         else search(size, n+1, nbound, nset, nsums, nused)
//       })
//     }
//   }

//   val sets = search(6, 11, 117, List(), Map(0 -> Set(0)), Set())
//   val sets = search(7, 20, 255, List(), Map(0 -> Set(0)), Set())
//   def answer = sets foreach(s => {
//     println(s + " -> " + valid(s toSet))
//   })
}
