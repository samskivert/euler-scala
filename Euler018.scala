object Euler018 extends EulerApp {
  val triangle = List(
     4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23,
      63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,
        91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
          70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
            53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14,
              41, 48, 72, 33, 47, 32, 37, 16, 94, 29,
                41, 41, 26, 56, 83, 40, 80, 70, 33,
                  99, 65,  4, 28,  6, 16, 70, 92,
                    88,  2, 77, 73,  7, 63, 67,
                      19,  1, 23, 75,  3, 34,
                        20,  4, 82, 47, 65,
                          18, 35, 87, 10,
                            17, 47, 82,
                              95, 64,
                                75
  );

  def fold (triangle :List[Int], max :List[Int]) :Int = {
    if (max.length == 1) {
      return max(0);
    } else {
      return fold(triangle.drop(max.length-1), List.range(0, max.length-1).map(
        (i) => (triangle(i) + math.max(max(i), max(i+1)))));
    }
  }
  var base = (math.sqrt(1+8*triangle.length) - 1).toInt / 2; // 15
  def answer = fold(triangle.drop(base), triangle.slice(0, base))
}
