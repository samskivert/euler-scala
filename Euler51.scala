object Euler51 extends EulerApp {
  def cprimes (n :String)(d :Char) = {
    val variants = "0123456789".toList.map(nd => n.replace(d, nd))
    variants.filter(n => !n.startsWith("0")).map(Integer.parseInt).filter(isprime).length
  }
  def count (prime :String) = {
    prime.toList.removeDuplicates.map(cprimes(prime)).reduceRight(Math.max)
  }
  println(genprimes(150000).filter(0.!=).find(p => count(p.toString) > 7).get)
}
