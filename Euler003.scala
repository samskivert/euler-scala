object Euler003 extends EulerApp {
  def lpf (divis :Long, divid :Long) :Long = {
    if (divid % divis == 0) lpf(2, divid/divis)
    else if (divis > math.sqrt(divid)) divid
    else lpf(divis+1, divid)
  }
  def answer = lpf(2l, 317584931803l)
}
