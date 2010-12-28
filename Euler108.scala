object Euler108 extends EulerApp {
  def facts (n :Int) = ((1 to n/2 filter(n%_ == 0)) :+ n) toList
  def sols (n :Int) = {
    def check (f :List[Int], acc :Set[Int]) :Set[Int] = f match {
      case Nil => acc
      case h :: t => check(t, acc ++ (t map(_ + h) filter(s => acc forall(s%_ != 0))))
    }
    val s = check(facts(n), Set())
    if (s.size > 250) println(n + " -> " + s)
    s
  }
  // def answer = Stream.from(1) find(n => sols(n).size > 999) get
  // def answer = 100000 to 110000 count(n => sols(n).size > 999)
  // def answer = 100000 to 110000 count(n => facts(n).size > 999)
  // def answer = 1 to 50 foreach { n => println(n + " -> " + (n*(n+1)/2-(n-1))) }
  def answer = 1 to 10 foreach { n => println(n + " -> " + sols(n)) }
}
