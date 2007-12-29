object Euler5 extends Application {
  def divisByOneToTwenty (value :Int) :Boolean = {
    for (i <- List.range(2, 21).reverse) {
      if (value % i != 0) {
        return false;
      }
    }
    return true;
  }

  var value :Int = 20;
  while (!divisByOneToTwenty(value)) {
    value = value + 20;
  }
  println(value);
}
