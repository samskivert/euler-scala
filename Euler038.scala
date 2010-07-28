object Euler038 extends Application {
  def ispan (n :String) = n.toList.sort(_<_).mkString == "123456789";
  println(List.range(9182,9876).reverse.map(n => n+""+(2*n)).filter(ispan).head);
  // or
  def catprod (n :Int, r :Int) = List.range(1, r+1).flatMap(p => (n*p).toString.toList)
  def find (n :Int, r :Int, max :Int) :Int = {
    val cp = catprod(n, r);
    if (cp.length > 9)
      if (r == 2) max
      else find(n, r-1, max);
    else
      if (ispan(cp)) find(n+1, r, Math.max(cp.mkString.toInt, max))
      else find(n+1, r, max);
  }
  println(find(1, 5, 0));
}
