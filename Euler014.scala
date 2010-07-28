import scala.collection.mutable.Map;

object Euler014 extends Application {
  var seen :Map[Long,Int] = Map();

  def iterate (value :Long) :Int = {
    val seenlen :Option[Int] = seen.get(value);
    if (seenlen != None) {
      return seenlen.get;
    } else if (value == 1) {
      return 1;
    } else if (value % 2 == 0) {
      val newlen = iterate(value/2)+1;
      seen.put(value, newlen);
      return newlen;
    } else {
      val newlen = iterate(3*value+1)+1;
      seen.put(value, newlen);
      return newlen;
    }
  }

  var longest = List.range(1, 1000000).map((n) => (Pair(n, iterate(n)))).foldLeft(Pair(0, 0))(
    (lpair, pair) => (if (lpair._2 > pair._2) lpair else pair));
  println(longest._1);
}
