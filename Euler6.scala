object Euler6 extends Application {
  def sum (values :List[Int]) = {
    values.foldLeft(0)((b, a) => (b + a))
  }
  def sumsq (values :List[Int]) :Int = {
    values.foldLeft(0)((b, a) => (b + a*a))
  }
  val first100sum = sum(List.range(1,101));
  val first100sumsq = sumsq(List.range(1,101));
  println("Sum of squares: " + first100sumsq);
  println("Square of sums: " + first100sum * first100sum);
  println("Difference: " + (first100sum * first100sum - first100sumsq));
}
