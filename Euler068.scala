object Euler068 extends EulerApp {
  class Ngon (vals :Seq[Int]) {
    protected val size = vals.length/2
    val total = line(0).sum
    def valid = !1.until(size).map(line(_).sum).exists(total.!=)
    override def toString () = 0.until(size).flatMap(line).mkString
    protected def line (n :Int) = List(vals(n), vals(size+n), vals(size+(n+1)%size))
  }

  def makegons (vals :Seq[Int], digits :Seq[Int]) :Seq[Ngon] = {
    if (digits.isEmpty) {
      val ngon = new Ngon(vals)
      if (ngon.valid) Seq(ngon) else Seq()
    } else {
      val ndigits = if (vals.length < digits.length) digits.filter(vals(0).<) else digits
      ndigits.flatMap(d => makegons(vals :+ d, digits.filterNot(_ == d)))
    }
  }
  def ngons (size :Int)(n :Int) = makegons(Seq(n), (1 to size).reverse.filterNot(_ == n))
  def answer = 8 to 1 by -1 flatMap(ngons(10)) head
}
