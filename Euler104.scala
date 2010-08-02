object Euler104 extends EulerApp {
  def ispan (digs :String) = digs.sortWith(_<_) == "123456789"
  def find (k :Int, n1 :BigInt, n2 :BigInt, mn1 :Int, mn2 :Int) :Int = {
    val n = n1+n2
    val mn = (mn1+mn2) % 1000000000
    if (ispan(mn.toString) && ispan(n.toString take 9)) k
    else find(k+1, n, n1, mn, mn1)
  }
  def answer = find(3, 1, 1, 1, 1)
}
