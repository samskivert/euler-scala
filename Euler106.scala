object Euler106 extends EulerApp {
  def fact (n :Int) :Int = if (n < 2) 1 else n * fact(n-1)
  def choose (n :Int, r :Int) = fact(n)/(fact(r)*fact(n-r))
  def gen (as :Int, bs :Int, acc :String) :Seq[String] =
    if (as == 0 && bs == 0) Vector(acc)
    else ((if (as != 0) gen(as-1, bs, acc+"a") else Vector()) ++
          (if (bs != 0) gen(as, bs-1, acc+"b") else Vector()))
  def check (str :String) =
    (1 to str.length/2).foldLeft(str)((b, a) => b.replace("ab", "")).length > 0
  def count (l :Int) = 2 to l/2  map(n => gen(n-1, n, "a").filter(check).size * choose(l, l-2*n))
  def answer = count(12) sum
}
