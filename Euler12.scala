object Euler12 extends Application {
  def findnum (i :Int, x :Int) :Int = {
    val divs = List.range(1, Math.sqrt(x)).filter(n => x % n == 0).flatMap(
      n => List(n, x/n).removeDuplicates);
    if (divs.length > 500) return x;
    else return findnum(i+1, x+i);
  }
  println(findnum(1, 0));
}
