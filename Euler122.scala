object Euler122 extends EulerApp {
  def answer = {
    val Max = 200
    val results = new Array[Int](Max+1)
    val steps = collection.mutable.Queue(collection.immutable.BitSet(1))
    var remain = Max-2 ; while (remain > 0) {
      val ns = steps.dequeue
      val n = ns.last
      val iter = ns.iterator ; while (iter.hasNext) {
        val nn = iter.next + n
        if (nn <= Max) {
          if (results(nn) == 0) {
            results(nn) = ns.size
            remain -= 1
          }
          if (!ns(nn)) steps += (ns + nn)
        }
      }
    }
    results.sum
  }
}
