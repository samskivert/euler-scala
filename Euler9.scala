object Euler9 extends Application {
  println(for { 
    a <- List.range(1, 1000)
    b <- List.range(a, 1000)
    c <- List.range(b, 1000)
    if (a*a + b*b == c*c && a+b+c == 1000)
  } yield a*b*c);
}
