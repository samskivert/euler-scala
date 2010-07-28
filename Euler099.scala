object Euler099 extends EulerApp {
  val nums = readlines("base_exp.txt") map(_.split(",")) map(a => (a(0).toInt, a(1).toInt))
  def answer = nums.map(p => p._2 * math.log(p._1)).zipWithIndex.sortWith(_._1>_._1).head._2 + 1
}
