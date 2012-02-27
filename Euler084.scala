import scala.util.Random
object Euler084 extends EulerApp {
  def goto (pos :Int) = (_ :Int) => pos
  def back (steps :Int) = (pos :Int) => pos-steps
  val nextrr = (pos :Int) => ((((pos + 5) / 10) * 10) + 5) % 40
  val nextut = (pos :Int) => if (pos >= 12 && pos < 28) 28 else 12
  val stay = (pos :Int) => pos
  val CHANCE = Random.shuffle(List(
    goto(0), goto(10), goto(11), goto(24), goto(39), goto(5), nextrr, nextrr,
    nextut, back(3), stay, stay, stay, stay, stay, stay))
  val CCHEST = Random.shuffle(List(
    goto(0), goto(10), stay, stay, stay, stay, stay, stay,
    stay, stay, stay, stay, stay, stay, stay, stay))

  val DIE = 4
  val ITERS = 10000000

  def compute () = {
    val hits = Array.fill(40)(0)
    var pos = 0
    var doubs = 0
    var nextch = 0
    var nextcc = 0
    var iter = ITERS

    while (iter > 0) {
      val d1 = Random.nextInt(DIE)+1
      val d2 = Random.nextInt(DIE)+1
      var npos = (pos + d1 + d2) % 40
      if (d1 == d2) {
        if (doubs == 2) {
          doubs = 0
          npos = 10
        } else {
          doubs = doubs + 1
        }
      } else {
        doubs = 0
      }
      if (npos == 7 || npos == 22 || npos == 36) {
        npos = CHANCE(nextch)(npos)
        nextch = (nextch + 1) % CHANCE.length
      }
      if (npos == 2 || npos == 17 || npos == 33) {
        npos = CCHEST(nextcc)(npos)
        nextcc = (nextcc + 1) % CCHEST.length
      }
      if (npos == 30) {
        npos = 10
      }
      hits(npos) += 1
      pos = npos
      iter -= 1
    }
    hits
  }
  def answer = compute.zipWithIndex.sortBy(_._1).reverse.take(3).map(_._2).mkString
}
