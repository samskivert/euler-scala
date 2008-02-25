object Euler51 extends EulerApp {
  val primes = genprimes(150000).filter(0.!=);
  def cprimes (n :String)(d :Char) :Int = {
    val variants = "0123456789".toList.map(nd => n.replace(d, nd));
    variants.filter(n => !n.startsWith("0")).map(Integer.parseInt).filter(isprime).length
  }
  def count (prime :String) :Int = {
    prime.toList.removeDuplicates.map(cprimes(prime)).foldRight(0)(Math.max)
  }
  def find (length :Int, idx :Int) :Int = {
    if (idx == primes.length) 0;
    else if (count(primes(idx).toString) >= length) primes(idx);
    else find(length, idx+1);
  }
  println(find(8, 0));
}
