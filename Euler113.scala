object Euler113 extends EulerApp {
  val decs = new MemoMap2[Int,Int,Long] {
    override def compute (d :Int, tens :Int) = 0 to d map(this(_, tens-1)) sum
  } ++= (0 to 9 map(d => ((d, 1), (d+1).toLong)))
  val incs = new MemoMap2[Int,Int,Long] {
    override def compute (d :Int, tens :Int) = d to 9 map(this(_, tens-1)) sum
  } ++= (1 to 9 map(d => ((d, 1), (10-d).toLong)))
  // 9 = non-bouncy 1-9, and 9*99 = overlap between incs and decs (e.g. 333)
  def answer = (2 to 100 map(z => decs(9, z)+incs(1, z)-1) sum) - 9*99 + 9
}
