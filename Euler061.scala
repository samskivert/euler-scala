object Euler061 extends EulerApp {
  case class Pn (card :Int, value :Int) {
    def valid = (value < 10000) && (value > 999)
    def ab = value / 100
    def cd = value % 100
  }

  def tri (n :Int) = Pn(3, n*(n+1)/2)
  def square (n :Int) = Pn(4, n*n)
  def pent (n :Int) = Pn(5, n*(3*n-1)/2)
  def hex (n :Int) = Pn(6, n*(2*n-1))
  def hept (n :Int) = Pn(7, n*(5*n-3)/2)
  def oct (n :Int) = Pn(8, n*(3*n-2))
  def gen (max :Int)(gen :(Int) => Pn) = (1 to max) map(gen) filter(_.valid)
  val nums = List(square _, pent _, hex _, hept _, oct _) flatMap(gen(100))

  def search (nums :Seq[Pn], set :List[Pn]) :Option[List[Pn]] =
    if (nums.isEmpty) Some(set) filter(x => x.last.cd == x.head.ab)
    else (nums filter(_.ab == set.last.cd) map(
      n => search(nums filter(_.card != n.card), set :+ n)) flatten) headOption
  def sets = gen(150)(tri) map(n => search(nums, n::Nil)) flatten
  def answer = (sets head) map(_.value) sum
}
