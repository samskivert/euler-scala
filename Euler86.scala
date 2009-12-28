import scala.collection.mutable.Map
object Euler86 extends EulerApp {
  def hyp (x :Int, y :Int) = x*x + y*y
  def minpath (h :Int, w :Int, d :Int) = Math.min(hyp(h+w,d), Math.min(hyp(h+d,w), hyp(w+d,h)))
  def isint (y :Double) = if (y - y.toInt == 0) 1 else 0
  def count (h :Int, w :Int, d :Int, c :Int, cache :Map[Int,Int]) :Int = {
    val mp = minpath(h, w, d)
    val nc = c + cache.getOrElseUpdate(mp, isint(Math.sqrt(mp)))
    if (d == h) {
      if (w == h) nc
      else count(h, w+1, w+1, nc, cache)
    } else count(h, w, d+1, nc, cache)
  }
  def search (h :Int, c :Int, target :Int, cache :Map[Int,Int]) :Int = {
    println(h + " -> " + c)
    if (c > target) h-1
    else search(h+1, count(h, 1, 1, c, cache), target, cache)
  }
  println(search(1, 0, 2000, Map[Int,Int]()))
  println(search(1, 0, 1000000, Map[Int,Int]()))
}
