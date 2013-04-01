object Euler121 extends EulerApp {
  val (max, maj) = (15, 8)
  def pfact (up :Int, low :Int, acc :Long = 1) :Long =
    if (up <= low) acc else pfact(up-1, low, acc*up)
  def count (red :Int, rpicks :Int, bpicks :Int) :Long = {
    if (bpicks == maj) pfact(max+1, red)
    else if (rpicks == maj || red > max) 0
    else red*count(red+1, rpicks+1, bpicks) + count(red+1, rpicks, bpicks+1)
  }
  def answer = pfact(max+1, 1) / count(1, 0, 0)
}
