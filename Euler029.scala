object Euler29 extends Application {
  println((for {
    a <- List.range(2, 101)
    b <- List.range(2, 101)
  } yield BigInt(a).pow(b)).removeDuplicates.length);
}
