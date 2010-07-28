object Euler003 extends Application {
  def lpf (divis :Long, divid :Long) :Long = {
    if (divid % divis == 0) lpf(2, divid/divis)
    else if (divis > Math.sqrt(divid)) divid 
    else lpf(divis+1, divid)
  }
  println(lpf(2l, 317584931803l));
}
