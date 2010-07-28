object Euler020 extends Application {
  def fact (n: BigInt): BigInt = if (n == 0) 1 else n * fact(n - 1)
  println(fact(100).toString().foldRight(0)((a, b) => (b + (a - '0'))));
}
