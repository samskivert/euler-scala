object Euler53 extends Application {
  def fact (n :BigInt) :BigInt = if (n < 2) 1 else n * fact(n-1);
  def choose (n :BigInt, r :BigInt) = fact(n)/(fact(r)*fact(n-r));
  def find (n :Int, r :Int, accum :Int) :Int = {
    val naccum = if (choose(n, r) > 1000000) accum+1 else accum;
    if (r < n) find(n, r+1, naccum);
    else if (n < 100) find(n+1, 1, naccum);
    else naccum;
  }
  println(find(1, 1, 0));
}
