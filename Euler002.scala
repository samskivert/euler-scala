object Euler002 extends EulerApp {
  def fibby (a :Int, b :Int) :Int = {
    val next = a + b;
    return (if (b % 2 == 0) b else 0) + (if (next > 1000000) 0 else fibby(b, next));
  }
  def answer = fibby(1, 2)
}
