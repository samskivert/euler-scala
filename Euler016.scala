object Euler16 extends Application {
  println(BigInt(2).pow(1000).toString().foldRight(0)((a, b) => (b + (a - '0'))));
}
