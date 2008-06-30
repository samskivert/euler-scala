object Euler60 extends EulerApp {
  def primepair (p1 :Int, p2 :Int) =
    isprime((p1.toString + p2).toInt) && isprime((p2.toString + p1).toInt)

  val plist = genprimes(2000).filter(0.!=)
  val pairs = new scala.collection.mutable.HashSet[String]()
  for (ii <- 0.until(plist.length-1); jj <- ii.until(plist.length))
    if (primepair(plist(ii), plist(jj)))
      pairs += (plist(ii)+"."+plist(jj))
  println(pairs.size)

  def ppair (p1 :Int, p2 :Int) = pairs(p1+"."+p2)

  def search (primes :Array[Int], list :List[Int], idx :Int) :List[Int] =
    if (list.length == 4) list
    else if (idx == primes.length) Nil
    else if (list.forall(ppair(_, primes(idx)))) search(primes, list+primes(idx), idx+1)
    else search(primes, list, idx+1)

  val sols = 0.until(plist.length).map(idx => search(plist, List(plist(idx)), idx+1))
  println(sols.filter(Nil.!=));
}
