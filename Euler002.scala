object Euler002 extends EulerApp {
  def fib (a :Int, b :Int) :Int =
    (if (b % 2 == 0) b else 0) + (if (a+b > 1000000) 0 else fib(b, a+b))
  def answer = fib(1, 2)
}
