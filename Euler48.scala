object Euler48 extends Application {
  val modulo = BigInt(10).pow(10);
  println(List.range(1, 1001).map(a => BigInt(a).pow(a)).foldRight(BigInt(0))(_+_) % modulo);
}
