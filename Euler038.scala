object Euler038 extends EulerApp {
  def ispan (n :String) = n.sortWith(_<_) == "123456789";
  def answer = (9182 to 9876).reverse.map(n => n+""+(2*n)).find(ispan).get

  // or

  def catprod (n :Int, r :Int) = ((1 until r).flatMap(p => (n*p).toString)).mkString
  def find (n :Int, r :Int, max :Int) :Int = {
    val cp = catprod(n, r)
    if (cp.length > 9)
      if (r == 2) max
      else find(n, r-1, max)
    else
      if (ispan(cp)) find(n+1, r, math.max(cp.mkString.toInt, max))
      else find(n+1, r, max)
  }
  def altanswer = find(1, 5, 0)
}
