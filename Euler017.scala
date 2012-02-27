object Euler017 extends EulerApp {
  val ones = Array("", "one", "two", "three", "four",
                   "five", "six", "seven", "eight", "nine");

  val tens = Array("ten", "twenty", "thirty", "forty",
                   "fifty", "sixty", "seventy", "eighty", "ninety");

  val teens = Array("ten", "eleven", "twelve", "thirteen", "fourteen",
                    "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");

  def speak (number :Int) :String = {
    if (number >= 1000) {
      return "onethousand";
    } else if (number >= 100) {
      if (number % 100 == 0) {
        return speak(number/100) + "hundred";
      } else {
        return speak(number/100) + "hundredand" + speak(number%100);
      }
    } else if (number >= 20) {
      if (number % 10 == 0) {
        return tens(number/10-1);
      } else {
        return tens(number/10-1) + speak(number%10);
      }
    } else if (number >= 10) {
      return teens(number-10);
    } else {
      return ones(number);
    }
  }

  def answer = List.range(1, 1001).foldRight(0) { (a, b) => (b + speak(a).length) }
}
