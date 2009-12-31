object Euler88 extends EulerApp {
  def minprodsum (k :Int) :Int = {
    val vec = Array.fill(k)(1)
    var s = k+2
    while (s < 2*k) {
      var ii = 0
      while (ii < vec.length) {
        vec(ii) = 1
        ii += 1
      }
      var p = s-k+1
      vec(vec.length-1) = p;
      // println("Foo " + vec.toList)
      while (p < s && vec(vec.length-1) > 2) {
        var idx = 0
        while (idx < vec.length-1 && vec(idx+1) <= 2) idx += 1
        if (idx < vec.length-2 && vec(idx+2)-vec(idx+1)>1) idx += 1
        val di = idx+1
        var ii = idx
        while (vec(ii) == vec(di)-1) ii -= 1
        val op = vec(di)*vec(ii)
        val np = op+vec(di)-vec(ii)-1
        p /= op
        p *= np
        vec(di) -= 1
        vec(ii) += 1
        // println("Checking " + vec.toList + " -> " + p + " ?= " + s)
      }
      if (p == s) {
        printf("mps %2d -> %2d %s\n", k, s, vec.toList.reverse.takeWhile(1.!=))
        return s
      }
      s += 2-k%2
    }
    printf("MPS %2d -> %2d List(%d, 2)\n", k, (2*k), k)
    return 2*k
  }
  println(2.to(120).map(minprodsum).removeDuplicates.sum)
//  println(2.to(12000).map(minprodsum).removeDuplicates.sum)
}
