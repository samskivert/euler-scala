object Euler40 extends Application {
  val digits = List.range(1, 200000).flatMap(n => n.toString.toList).map(_-'0');
  println(List.range(0, 6).foldRight(1)((idx, b) => b * digits(Math.pow(10, idx).intValue-1)));
}
