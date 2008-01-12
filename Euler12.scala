object Euler12 extends Application {
  def findnum (i :Int, x :Int) :Int = {
    var divs = List.flatten(for {
      div <- List.range(1, Math.sqrt(x)+1)
      if x % div == 0
    } yield List(div, x / div).removeDuplicates);
    if (divs.length > 500) return x;
    else return findnum(i+1, x+i);
  }
  println(findnum(1, 0));
}
