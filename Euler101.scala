object Euler101 extends EulerApp {
  def e2v (exp :Int) = ("abcdefghij"(exp)).toString

  case class Term (const :Double, exp :Int) {
    def add (term :Term) = {
      if (term.exp != exp) error("Illegal addition of " + term + " to " + this)
      Term(const + term.const, exp)
    }
    def mult (c :Double) = Term(c*const, exp)
    def div (c :Double) = Term(const/c, exp)
    def neg = Term(-const, exp)
    def subst (sum :List[Term]) = sum.map(_.mult(const))
    override def toString = if (exp == -1) (""+const)
                            else if (const == 1) e2v(exp)
                            else const + e2v(exp)
  }

  case class Eq (terms :List[Term]) {
    def solve (exp :Int) = {
      val t = terms.find(_.exp == exp).head
      Eq(terms.filterNot(t.==).map(_.neg)).div(t.const)
    }
    def subst (exp :Int, eq :Eq) =
      Eq(terms.flatMap(t => if (t.exp == exp) t.subst(eq.terms) else List(t)).
         groupBy(_.exp).values.map(_.reduceLeft(_.add(_))).toList)
    def div (c :Double) = Eq(terms.map(_.div(c)))
    def toCoeff = if (terms.length > 1 || terms.head.exp != -1)
                    error("Converting unsolved equation to int " + this)
                  else if (terms.head.const.toLong != terms.head.const)
                    error("Non-integer solution " + this)
                  else terms.head.const.toLong
    override def toString = terms.mkString(" + ")
  }

  def solve (eqns :List[Eq], sols :List[Eq]) :List[Eq] = {
    val sol = sols.zipWithIndex.foldLeft(eqns.head)((e, p) => e.subst(p._2, p._1)).solve(sols.size)
    if (eqns.tail.isEmpty) sol :: Nil
    else {
      val nsols = solve(eqns.tail, sols :+ sol)
      nsols.zipWithIndex.foldLeft(sol)((e, p) => e.subst(sols.length+1+p._2, p._1)) :: nsols
    }
  }

  def pow (n :Int, e :Int) = math.pow(n, e).toLong

  def gen (terms :Int, f :Int => Long) = {
    def gen1 (n :Int) = (0 until terms).map(i => Term(pow(n, i), i)).toList :+ Term(-f(n), -1)
    1 to terms map(n => Eq(gen1(n))) toList
  }

  def eval (coefs :List[Long], x :Int) =
    coefs.zipWithIndex.foldLeft(0L)((v, p) => v + p._1*pow(x, p._2))

  def tenth (n :Int) = (1 - n + n*n - pow(n, 3) + pow(n, 4) - pow(n, 5) +
                        pow(n, 6) - pow(n, 7) + pow(n, 8) - pow(n, 9) + pow(n, 10))

  def answer = (1 to 10).map(n => solve(gen(n, tenth), Nil).map(_.toCoeff)).
                         map(c => eval(c, c.length+1)) sum
}
