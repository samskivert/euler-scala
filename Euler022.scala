object Euler022 extends EulerApp {
  val names = readwords("names.txt");
  def score (name :String) = name.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  def answer = List.range(0, names.length).map(i => ((i+1) * score(names(i)))).sum
}
