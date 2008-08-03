object Euler60 extends EulerApp {
  def primepair (p1 :Int, p2 :Int) =
    isprime((p1.toString+p2).toInt) && isprime((p2.toString+p1).toInt)

  val plist = genprimes(10000).filter(0.!=)
  val ppairs = new scala.collection.mutable.HashSet[Int]
  for (ii <- 0.until(plist.length-1); jj <- ii.until(plist.length))
    if (primepair(plist(ii), plist(jj)))
      ppairs += (plist(ii)*10000 + plist(jj))

  def isset (pset :List[Int], prime :Int) :Boolean =
    pset.isEmpty || (ppairs(pset.head*10000+prime) && isset(pset.tail, prime))
  def find (pset :List[Int], plist :List[Int]) :Option[List[Int]] = {
    if (pset.size == 5) Some(pset)
    else if (plist.isEmpty) None
    else if (!isset(pset, plist.head)) find(pset, plist.tail)
    else find(plist.head :: pset, plist.tail).orElse(find(pset, plist.tail))
  }

  println(find(Nil, plist.toList).get.sum)
}
