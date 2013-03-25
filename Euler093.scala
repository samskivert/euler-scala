object Euler093 extends EulerApp {
  trait Expr { def eval :Float }
  case class Plus (a :Expr, b :Expr) extends Expr { def eval = a.eval + b.eval }
  case class Minus (a :Expr, b :Expr) extends Expr { def eval = a.eval - b.eval }
  case class Mult (a :Expr, b :Expr) extends Expr { def eval = a.eval * b.eval }
  case class Div (a :Expr, b :Expr) extends Expr { def eval = a.eval / b.eval }
  case class Const (c :Float) extends Expr { def eval = c }
  implicit def intToConst (c :Int) = Const(c)

  type Gen = (Expr, Expr) => Expr
  val opgen = List(Plus.apply _, Minus.apply _, Mult.apply _, Div.apply _)

  def genexprs (vals :List[Int], mkex :(Gen, Gen, Gen, Int, Int, Int, Int) => Expr) =
    for (o1 <- opgen; o2 <- opgen; o3 <- opgen; l1 <- vals;
         vals2 = vals filterNot l1.==; l2 <- vals2;
         vals3 = vals2 filterNot l2.==; l3 <- vals3;
         vals4 = vals3 filterNot l3.==; l4 <- vals4)
    yield mkex(o1, o2, o3, l1, l2, l3, l4)

  def reduce (es :Seq[Expr]) = es map(e => e.eval) filter(r => r > 0 && r.toInt == r) map(_.toInt)

  def gendigs (vals :List[Int]) = {
    import scala.collection.immutable.TreeSet
    val lls = genexprs(vals, (o1, o2, o3, l1, l2, l3, l4) => o1(o2(o3(l1, l2), l3), l4))
    val rrs = genexprs(vals, (o1, o2, o3, l1, l2, l3, l4) => o1(l1, o2(l2, o3(l3, l4))))
    val bbs = genexprs(vals, (o1, o2, o3, l1, l2, l3, l4) => o1(o2(l1, l2), o3(l3, l4)))
    val lrs = genexprs(vals, (o1, o2, o3, l1, l2, l3, l4) => o1(o2(l1, o3(l2, l3)), l4))
    val rls = genexprs(vals, (o1, o2, o3, l1, l2, l3, l4) => o1(l1, o2(o3(l2, l3), l4)))
    TreeSet[Int]() ++ reduce(lls) ++ reduce(rrs) ++ reduce(bbs) ++ reduce(lrs) ++ reduce(rls)
  }

  def proc (l :List[Int]) = (l.mkString, (0 /: gendigs(l)) ((k, v) => if (k == v-1) v else k))
  val sets = for (a <- 1 to 9; b <- (a+1) to 9; c <- (b+1) to 9; d <- (c+1) to 9)
             yield proc(List(a, b, c, d))
  def answer = sets.sortWith(_._2 > _._2).head._1
}
