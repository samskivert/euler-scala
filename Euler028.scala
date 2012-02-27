object Euler028 extends EulerApp {
  def spiral (size :Int) :Int = {
    val smaller = size-2
    if (size == 1) 1
    else spiral(smaller) + 4*(smaller*smaller) + (1+2+3+4)*(smaller+1)
  }
  def answer = spiral(1001)
}
