object Euler014 extends EulerApp {
  def answer = {
    var chain = new scala.collection.mutable.HashMap[Long,Int] {
      override def default (value :Long) = {
        val n = if (value == 1) 1
                else if (value % 2 == 0) apply(value/2)+1
                else apply(3*value+1)+1
        put(value, n)
        n
      }
    }
    (1L until 1000000 map(n => (n, chain(n))) maxBy(_._2))._1
  }
}
