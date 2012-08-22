object Euler117 extends EulerApp {
  val count = new MemoMap[Int,Long] {
    override def compute (remain :Int) =
      if (remain < 5) 1 << (remain-1) // 0 => 0, 1 => 1, 2 => 2, 3 => 4, 4 => 8
      else apply(remain-4) + apply(remain-3) + apply(remain-2) + apply(remain-1)
  }
  def answer = count(50)
}
