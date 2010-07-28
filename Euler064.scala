object Euler064 extends EulerApp {
  case class Root (root :Int, add :Int, div :Int) {
    def expand = {
      val term = ((Math.sqrt(root.toDouble) + add)/div).toInt
      val nadd = (term*div)-add
      (term, Root(root, nadd, (root + -nadd*nadd)/div))
    }
    override def toString = "(√" + root + "+" + add + ")/" + div
  }

  def expansion (terms :List[Int], roots :List[Root]) :List[Int] = {
    val (term, root) = roots.last.expand
    if (root.div == 0 || roots.indexOf(root) != -1) terms + term
    else expansion(terms + term, roots + root)
  }
  println(1.to(10000).map(n => expansion(Nil, Nil+Root(n, 0, 1)).length).filter(_%2==0).length)
}
