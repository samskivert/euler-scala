object Euler79 extends EulerApp {
  def matchp (c1 :Char, c2 :Char)(code :String) = c1 == code(0) && c2 == code(2)
  def find (codes :List[String], code :String, pos :Int) :String =
    if (codes.length == 0) code
    else codes.find(matchp(code(pos), code(pos+1))) match {
      case None =>
        if (pos < code.length-2) find(codes, code, pos+1) else code
      case Some(c) =>
        find(codes.filterNot(_ == c), code.patch(pos+1, c.slice(1, 2), 0), pos)
    }
  val codes = readlines("keylog.txt").removeDuplicates
  val (fst, snd, thd) = codes.foldLeft(Set[Char](), Set[Char](), Set[Char]())(
    (s, b) => (s._1+b(0), s._2+b(1), s._3+b(2)))
  val middle = find(codes.drop(1), codes.head, 0)
  println((fst -- (snd ++ thd)).head + middle + (thd -- (fst ++ snd)).head)
}
