object Euler101 extends EulerApp {
  case class Term (const :Double, exp :Int) {
    def add (term :Term) = Term(const + term.const, exp)
    def mult (c :Double) = Term(c*const, exp)
    def div (c :Double) = Term(const/c, exp)
    def neg = Term(-const, exp)
    def subst (sum :Seq[Term]) = sum.map(_.mult(const))
  }

  case class Eq (terms :Seq[Term]) {
    def solve (exp :Int) = {
      val t = terms.find(_.exp == exp).head
      Eq(terms.filterNot(t.==).map(_.neg).map(_.div(t.const)))
    }
    def subst (exp :Int, eq :Eq) =
      Eq(terms.flatMap(t => if (t.exp == exp) t.subst(eq.terms) else List(t)).
               groupBy(_.exp).values.map(_.reduceLeft(_.add(_))).toList)
    def reduce (eqs :Seq[Eq], c :Int) =
      (this /: eqs.zipWithIndex)((e, p) => e.subst(c+p._2, p._1))
  }

  def loop (eqs :List[Eq], sols :Seq[Eq]) :List[Eq] = {
    val sol = eqs.head.reduce(sols, 0).solve(sols.size)
    if (eqs.tail.isEmpty) sol :: Nil
    else {
      val nsols = loop(eqs.tail, sols :+ sol)
      sol.reduce(nsols, sols.length+1) :: nsols
    }
  }
  def solve (eqs :List[Eq]) = loop(eqs, Nil) map(_.terms.head.const.toLong)

  def gen (terms :Int, f :Int => Long) = List.range(1, terms+1) map(
    n => Eq((0 until terms map(i => Term(math.pow(n, i).toLong, i))) :+ Term(-f(n), -1)))
  def eval (coefs :List[Long], x :Int) =
    (0L /: coefs.zipWithIndex)((v, p) => v + p._1 * math.pow(x, p._2).toLong)
  def u (n :Int) = List.fill(10)(n).scanLeft(1L)(-_*_).sum
  def answer = 1 to 10 map(n => solve(gen(n, u))) map(c => eval(c, c.length+1)) sum
}
