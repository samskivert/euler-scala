object Euler25 extends Application {
  val ONE :BigInt = 1;

  def digits (value :BigInt) :BigInt = {
    if (value > 9) {
      return ONE + digits(value/10);
    } else {
      return ONE;
    }
  }

  var prev2 :BigInt = ONE;
  var prev1 :BigInt = ONE;
  var value :BigInt = prev2 + prev1;
  var term = 3;

  while (digits(value) < 1000) {
    prev2 = prev1;
    prev1 = value;
    value = prev1 + prev2;
    term += 1;
  }

  println(term);
}
