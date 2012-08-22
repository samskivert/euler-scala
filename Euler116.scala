object Euler116 extends EulerApp {
  def count (len :Int) = new MemoMap[Int,Long] {
    override def compute (remain :Int) =
      if (remain < len) 0
      else 1 + apply(remain-len) + apply(remain-1)
  }
  def answer = count(4)(50) + count(3)(50) + count(2)(50)
}
