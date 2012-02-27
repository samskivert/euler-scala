object Euler053 extends EulerApp {
  def fact (n :BigInt) :BigInt = if (n < 2) 1 else n * fact(n-1)
  def choose (n :BigInt, r :BigInt) = fact(n)/(fact(r)*fact(n-r))
  def answer = (for (n <- 1 to 100; r <- 1 to n; if (choose(n, r) > 1000000)) yield 1).sum
}
