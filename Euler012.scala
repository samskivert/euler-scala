object Euler012 extends EulerApp {
  def findnum (i :Int, x :Int) :Int = {
    val divs = (1 to math.sqrt(x).toInt).filter(x % _ == 0).flatMap(n => List(n, x/n).distinct)
    if (divs.length > 500) x
    else findnum(i+1, x+i)
  }
  def answer = findnum(1, 0)
}
