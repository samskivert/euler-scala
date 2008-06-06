object Euler22 extends EulerApp {
  val names = readwords("names.txt");
  def score (name :String) = name.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  println(List.range(0, names.length).map(i => ((i+1) * score(names(i)))).sum);
}
