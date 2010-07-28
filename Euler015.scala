object Euler015 extends Application {
  val size = 20;
  def fact (n: BigInt): BigInt = if (n == 0) 1 else n * fact(n - 1)
  println(fact(size * 2) / (fact(size) * fact(size)))
}
