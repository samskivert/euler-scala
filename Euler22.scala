import scala.io.Source;
object Euler22 extends Application {
  def trim (name :String) = name.slice(1, name.length-1);
  val names = Source.fromFile("names.txt").getLine(0).split(',').map(trim).toList.sort(_<_);
  def score (name :String) = name.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  println(List.range(0, names.length).map(i => ((i+1) * score(names(i)))).foldLeft(0)(_+_));
}
