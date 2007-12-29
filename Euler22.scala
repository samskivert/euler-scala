import scala.io.Source;

object Euler22 extends Application {
  val names = Source.fromFile("names.txt").getLine(0).split(',').map {
    (n) => n.slice(1, n.length-1)
  }.toList.sort { (a,b) => ( a < b) };

  var score = 0;
  for (i <- List.range(0, names.length)) {
    score = score + (i+1) * names(i).toList.foldRight(0) { (a, b) => (b + (a - 'A' + 1)) };
  }
  println(score);
}
