object Euler6 extends Application {
  val first100sum = List.range(1,101).foldLeft(0)(_+_);
  val first100sumsq = List.range(1,101).foldLeft(0)((b, a) => (b + a*a));
  println("Sum of squares: " + first100sumsq);
  println("Square of sums: " + first100sum * first100sum);
  println("Difference: " + (first100sum * first100sum - first100sumsq));
}
