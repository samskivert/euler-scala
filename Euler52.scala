object Euler52 extends Application {
  def sort (n :Int) = n.toString.toList.sort(_<_).mkString.toInt;
  def find (n :Int) :Int = {
    val sn = sort(n);
    if (List.range(2, 7).map(m => sort(n*m)).foldRight(true)((a, b) => b && a == sn)) n;
    else find(n+1);
  }
  println(find(1));
}
