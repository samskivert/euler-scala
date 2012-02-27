object Euler055 extends EulerApp {
  def ispal (n :String) = n.take(n.length/2) == n.takeRight(n.length/2).reverse
  def islychrel (n :BigInt, iter :Int = 0) :Int =
    if (iter > 0 && ispal(n.toString)) 0
    else if (iter == 50) 1
    else islychrel(n + BigInt(n.toString.reverse), iter+1)
  def answer = 1 to 9999 map(n => islychrel(n)) sum
}
