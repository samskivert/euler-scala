object Euler10 extends Application {
  var numbers = List.range(2,1000000).toArray;
  def sumprimes (idx :Int, sum :Long) :Long = {
    var prime = numbers(idx);
    for (midx <- List.range(idx, numbers.length, prime)) {
      numbers(midx) = 0;
    }
    val nidx = numbers.slice(idx, numbers.length).findIndexOf((a) => (a != 0));
    if (nidx == -1) return sum + prime;
    else return sumprimes(idx + nidx, sum + prime);
  }
  println(sumprimes(0, 0));
}
