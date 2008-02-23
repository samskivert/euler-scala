object Euler45 extends Application {
  def findh (pent :Long, h :Long) :Long = {
    val hex = h*(2*h-1);
    if (hex > pent) findh(pent, h-1);
    else if (hex < pent) 0;
    else hex;
  }
  def findp (tri :Long, p :Long) :Long = {
    val pent = p*(3*p-1)/2;
    if (pent > tri) findp(tri, p-1);
    else if (pent < tri) 0;
    else findh(pent, p-1);
  }
  def find (t :Long) :Long = {
    val n = findp(t*(t+1)/2, t-1);
    if (n != 0) n;
    else find(t+1);
  }
  println(find(286));
}
