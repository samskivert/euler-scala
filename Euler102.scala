object Euler102 extends EulerApp {
  case class Vec (x :Double, y :Double, z :Double) {
    def cross (v :Vec) = Vec(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x)
    def dot (v :Vec) = x*v.x + y*v.y + z*v.z
    def - (v :Vec) = Vec(x-v.x, y-v.y, z-v.z)
  }
  def sameside (p1 :Vec, p2 :Vec, a :Vec, b :Vec) =
    (((b - a) cross (p1 - a)) dot ((b - a) cross (p2 - a))) >= 0
  def contains (a :Vec, b :Vec, c :Vec, p :Vec) =
    sameside(p, a, b, c) && sameside(p, b, a, c) && sameside(p, c, a, b)
  val tris = for (Array(x1, y1, x2, y2, x3, y3) <-
                  readlines("triangles.txt") map(_.split(",") map(_.toInt)))
             yield (Vec(x1, y1, 0), Vec(x2, y2, 0), Vec(x3, y3, 0))
  def answer = tris count(t => contains(t._1, t._2, t._3, Vec(0, 0, 0)))
}
