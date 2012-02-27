object Euler079 extends EulerApp {
  def pop (fc :Char)(c :String) = if (c.head == fc) c.tail else c
  def find (codes :List[String], code :String) :String = {
    val (fs, ss) = codes.unzip(s => (s(0), s.drop(1)))
    (fs.toSet -- ss.flatMap(_.toList).toSet).headOption match {
      case None => code
      case Some(fc) => find(codes.map(pop(fc)).filterNot(_.isEmpty), code + fc)
    }
  }
  def answer = find(readlines("keylog.txt"), "")
}
