object Euler062 extends EulerApp {
  val cubes = new scala.collection.mutable.HashMap[Long,List[Long]]
  def search (n :Long) :Long = {
    val cube = n*n*n
    val key = cube.toString.toList.sort(_>_).mkString.toLong
    val perms = cubes.put(key, cubes.get(key).getOrElse(Nil) + cube).getOrElse(Nil)
    if (perms.length == 4) perms.head
    else search(n+1)
  }
  println(search(1))
}
