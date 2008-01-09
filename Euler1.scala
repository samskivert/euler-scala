object Euler1 extends Application {
  println(List.range(0, 1000).filter((a) => (a % 3 == 0 || a % 5 == 0)).foldLeft(0)(_+_));
}
