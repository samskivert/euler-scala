object Euler39 extends Application {
  def sols (perim :Int) :Int = {
    var sols = 0;
    for (a <- List.range(1, perim-1); b <- List.range(a, a+(perim-a)/2)) {
      val c = perim-a-b;
      if (a*a + b*b == c*c) sols = sols + 1;
    }
    sols;
  }
  println(List.range(3, 1000).map(n => sols(n)*1000 + n).foldRight(0)(Math.max) % 1000);
}
