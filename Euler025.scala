object Euler025 extends Application {
  var prev2 :BigInt = 1;
  var prev1 :BigInt = 1;
  var value :BigInt = prev2 + prev1;
  var term = 3;
  while (value.toString.length < 1000) {
    prev2 = prev1;
    prev1 = value;
    value = prev1 + prev2;
    term += 1;
  }
  println(term);
}
