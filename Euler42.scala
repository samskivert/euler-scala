object Euler42 extends EulerApp {
  val words = readwords("words.txt");
  def wvalue (name :String) = name.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  def istri (value :Int, n :Int) :Int = {
    val ntri = (n*(n+1))/2;
    if (ntri == value) return 1;
    else if (ntri > value) return 0;
    else return istri(value, n+1);
  }
  println(words.foldLeft(0)((count, word) => (count + istri(wvalue(word), 1))));
}
