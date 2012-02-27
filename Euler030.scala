object Euler030 extends EulerApp {
  def digits (n :Int) = n.toString.map(_ - '0')
  def issum5 (n :Int) = digits(n).map(a => math.pow(a, 5).intValue()).sum == n
  def answer = (2 until 200000) filter(issum5) sum
}
