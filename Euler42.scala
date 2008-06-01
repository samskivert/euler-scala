object Euler42 extends EulerApp {
  def wvalue (word :Seq[Char]) = word.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  def tri (n :Int) = (n*(n+1))/2
  println(readwords("words.txt").map(wvalue).filter(v => (v == tri(Math.sqrt(2*v)))).length);
}
