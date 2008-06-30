object Euler61 extends EulerApp {
  case class Pn (card :Int, n :Int, value :Int) {
    def digits = value.toString.length
    def head = value.toString.substring(0, 2)
    def tail = value.toString.substring(2)
    override def toString = "P" + card + "," + n + "=" + value
  }

  def tri (n :Int) = Pn(3, n, n*(n+1)/2)
  def square (n :Int) = Pn(4, n, n*n)
  def pent (n :Int) = Pn(5, n, n*(3*n-1)/2)
  def hex (n :Int) = Pn(6, n, n*(2*n-1))
  def hept (n :Int) = Pn(7, n ,n*(5*n-3)/2)
  def oct (n :Int) = Pn(8, n, n*(3*n-2))

  def search (nums :Seq[Pn], set :List[Pn]) :List[Pn] = {
    if (!nums.isEmpty)
      nums.filter(set.last.tail == _.head).projection.map(
        n => search(nums.filter(_.card != n.card), set+n)).find(Nil.!=).getOrElse(Nil)
    else if (set.last.tail == set.first.head) set
    else Nil
  }

  val nums = List[(Int) => Pn](square, pent, hex, hept, oct).flatMap(
    f => 1.to(100).map(f).filter(_.digits == 4))
  val tris = 1.to(150).map(tri).filter(_.digits == 4)
  val set = tris.projection.map(t => search(nums, List(t))).find(Nil.!=).get
  println(set.map(_.value).sum)
}
