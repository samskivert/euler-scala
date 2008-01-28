object Euler40 extends Application {
  val digits = List.range(1, 200000).flatMap(n => n.toString.toList).map(_-'0');
  println(List(0, 9, 99, 999, 9999, 99999, 999999).foldRight(1)((idx, b) => b * digits(idx)));
}
