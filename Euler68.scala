object Euler68 extends EulerApp {
  class Ngon (vals :Seq[Int]) {
    protected val size = vals.length/2
    val total = line(0).sum
    def valid = !1.until(size).map(line(_).sum).exists(total.!=)
    override def toString () = 0.until(size).flatMap(line).mkString
    protected def line (n :Int) = List(vals(n), vals(size+n), vals(size+(n+1)%size))
  }

  def makegons (vals :List[Int], digits :List[Int]) :List[Ngon] = {
    if (digits == Nil) {
      val ngon = new Ngon(vals)
      if (ngon.valid) ngon :: Nil else Nil
    } else {
      val ndigits = if (vals.length < digits.length) digits.filter(vals(0).<) else digits
      ndigits.flatMap(d => makegons(vals + d, digits.filter(d.!=)))
    }
  }
  def ngons (size :Int, n :Int) = makegons(List(n), 1.to(size).toList.reverse-n)
  println(8.to(1).by(-1).flatMap(n => ngons(10, n)).first)
}
