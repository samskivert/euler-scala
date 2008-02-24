object Euler49 extends EulerApp {
  def sort (n :Int) = n.toString.toList.sort(_<_).mkString.toInt;
  for (n <- List.range(1488, 10000-2*3330)) {
    val n1 = n+3330;
    val n2 = n+2*3330;
    if (isprime(n) && isprime(n1) && isprime(n2) &&
        sort(n1) == sort(n) && sort(n2) == sort(n)) {
      println("" + n + n1 + n2);
    }
  }
}
