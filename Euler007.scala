object Euler007 extends EulerApp {
  def answer = {
    var numbers = List.range(2,110000);
    var primes = List(2);
    while (primes.length < 10001) {
      val prime = primes.head;
      numbers = numbers.filter((b) => (b%prime != 0));
      primes = numbers.head :: primes;
    }
    primes.head
  }
}
