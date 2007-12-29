import scala.collection.mutable.Map;

object Euler14 extends Application {
  var seen :Map[Long,Int] = Map();

  def iterate (length :Int, value :Long) :Int = {
    val seenlen :Option[Int] = seen.get(value);
    if (seenlen != None) {
      return length + seenlen.get - 1;
    } else if (value == 1) {
      return length+1;
    } else if (value % 2 == 0) {
      return iterate(length+1, value/2);
    } else {
      return iterate(length+1, 3*value+1);
    }
  }

  def itcache (num :Int) :Array[Long] = {
    val value :Long = num;
    seen.put(value, iterate(0, value));
    Array(value, seen.apply(value))
  }

  var longest = List.range(1, 1000000).map(itcache).foldLeft(Array(0L, 0L))(
    (lpair, pair) => (if (lpair(1) > pair(1)) lpair else pair));
  println(longest(0));
}
