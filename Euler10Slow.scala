object Euler10Slow extends Application {
  var numbers = List.range(2,1000000);
  var sum :Long = 0;
  while (numbers.length > 0) {
    val nextprime = numbers.head;
    sum += nextprime;
    numbers = numbers.filter((b) => (b%nextprime != 0));
  }
  println(sum);
}
