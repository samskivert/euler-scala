object Euler036 extends EulerApp {
  def ispal (n :String) = n.reverse.sameElements(n)
  def bothpal (n :Int) = ispal(n.toString) && ispal(n.toBinaryString)
  def answer = (1 until 1000000 by 2) filter(bothpal) sum
}
