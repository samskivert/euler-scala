object Euler10 extends Application {
  var numbers = List.range(2,1000000).toArray;
  var sum :Long = 0;
  var idx = 0;
  while (idx >= 0) {
    var prime = numbers(idx);
    sum += prime;
    var midx = idx;
    while (midx < numbers.length) {
      numbers(midx) = 0;
      midx += prime;
    }
    val nidx = numbers.slice(idx, numbers.length).findIndexOf((a) => (a != 0));
    if (nidx == -1) idx = -1 else idx = idx + nidx;
  }
  println(sum);
}
