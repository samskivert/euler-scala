object Euler074 {
  val facts = Array(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880);
  def sumfact (n :Int) :Int = if (n == 0) 0 else sumfact(n/10) + facts(n%10)

  val cache = new scala.collection.mutable.HashMap[Int,Int]
  def memoize (chain :List[Int], length :Int) :Int = {
    cache.put(chain.head, length)
    if (chain.tail.isEmpty) length else memoize(chain.tail, length+1)
  }

  def compute (chain :List[Int]) :Int = {
    val next = sumfact(chain.head)
    val memo = cache.get(next)
    if (memo.isDefined) memoize(chain, memo.get+1)
    else if (chain.indexOf(next) >= 0) memoize(chain, 1)
    else compute(next :: chain)
  }
  def answer = (1 until 1000000).map(n => compute(n :: Nil)).filter(_ == 60).length
}
