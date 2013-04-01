object Euler120 extends EulerApp {
  def pow (n :Int, p :Int, mod :Int, acc :Int = 1) :Int =
    if (p == 0) acc else pow(n, p-1, mod, acc*n % mod)
  def r (a :Int, n :Int) = ((pow(a-1, n, a*a) + pow(a+1, n, a*a)) % (a*a))
  def maxr (a :Int, n :Int = 1, acc :List[Int] = Nil) :Int = {
    val nacc = r(a, n) :: acc
    if (n % 2 != 0) maxr(a, n+1, nacc)
    else if (nacc startsWith nacc.drop(n/2)) nacc.max
    else maxr(a, n+1, nacc)
  }
  def answer = (3 to 1000) map(n => maxr(n)) sum
}
