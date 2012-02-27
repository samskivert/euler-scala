object Euler042 extends EulerApp {
  def wvalue (word :String) = word.foldLeft(0)((s, l) => (s + (l - 'A' + 1)))
  def tri (n :Int) = (n*(n+1))/2
  def answer = readwords("words.txt").map(wvalue).filter(v => v == tri(math.sqrt(2*v).toInt)).length
}
