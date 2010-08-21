object Euler062 extends EulerApp {
  def search (n :Long, cubes :Map[Long,List[Long]]) :Long = {
    val cube = n*n*n
    val key = cube.toString.sortWith(_>_).toLong
    val perms = cube :: cubes.getOrElse(key, Nil)
    if (perms.length == 5) perms.last
    else search(n+1, cubes + (key -> perms))
  }
  def answer = search(1, Map())
}
