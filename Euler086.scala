object Euler086 extends EulerApp {
  def search (target :Int, h :Int, c :Int) :Int = {
    var nc = c
    for (w <- 1 to h; d <- w to h) {
      val mp = math.sqrt((w+d)*(w+d) + h*h)
      if (mp - mp.toInt == 0) nc += 1
    }
    if (nc > target) h
    else search(target, h+1, nc)
  }
  def answer = search(1000000, 1, 0)
}
