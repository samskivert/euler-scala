object Euler55 extends Application {
  def ispan (n :String) =
    n.substring(0, n.length/2) == n.substring(n.length-n.length/2).reverse.mkString;
  def islychrel (n :BigInt, iter :Int) :Boolean = {
    if (iter > 0 && ispan(n.toString)) true;
    else if (iter == 50) false;
    else islychrel(n + BigInt(n.toString.reverse.mkString), iter+1);
  }
  println(List.range(1, 10000).filter(n => !islychrel(n, 0)).length);
}
