object Euler27 extends Application {
  def spiral (size :Int) :Int = {
    if (size == 1) {
      return 1;
    } else {
      val smaller = size-2;
      val start = smaller*smaller;
      val step = smaller+1;
      return spiral(smaller) + ((start + 1*step) + (start + 2*step) +
                                (start + 3*step) + (start + 4*step));
    }
  }
  println(spiral(1001));
}
