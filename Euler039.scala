object Euler039 extends EulerApp {
  def sols (perim :Int) = perim + 1000 * (for {
    a <- List.range(1, perim/2);
    b <- List.range(1, (perim-a)/2+1);
    c <- List(perim-a-b);
    if (a*a + b*b == c*c)
  } yield 1).length;
  def answer = List.range(3, 1000).map(sols).max % 1000
}
