object Euler064 extends EulerApp {
  case class Root (root :Int, add :Int, div :Int) {
    def expand = {
      val term = ((math.sqrt(root) + add)/div).toInt
      val nadd = term*div - add
      (term, Root(root, nadd, (root - nadd*nadd)/div))
    }
    override def toString = "(√" + root + "+" + add + ")/" + div
  }
  def expansion (terms :List[Int], roots :List[Root]) :List[Int] = {
    val (term, root) = roots.head.expand
    if (root.div == 0 || roots.contains(root)) term :: terms
    else expansion(term :: terms, root :: roots)
  }
  def answer = 1 to 10000 map(n => expansion(Nil, Root(n, 0, 1)::Nil).length) count(_%2==0)
}
