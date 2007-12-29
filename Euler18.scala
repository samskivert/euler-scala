object Euler18 extends Application {
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

  def maxadd (max :List[Int], add :List[Int]) :List[Int] = {
    var result :Array[Int] = Array.make(add.length, 0);
    for (i <- List.range(0, add.length)) {
      result(i) = add(i) + Math.max(max(i), max(i+1));
    }
    return result.toList;
  }

  var offset = 0;
  var max :List[Int] = triangle.slice(offset, 15);
  for (width <- List.range(2, max.length+1).reverse) {
    offset = offset + width;
    max = maxadd(max, triangle.slice(offset, offset+width-1));
  }

  println(max(0));
}
