import scala.io.Source;
import scala.runtime.RichString;

class EulerApp extends Application {
  class RichInterable (it :Iterable[Int]) {
    def sum = it.foldLeft(0)(_+_)
    def max = it.foldLeft(0)(Math.max)
  }
  implicit def richInterable (it: Iterable[Int]) = new RichInterable(it)

  def isprime (n :Int) :Boolean = {
    List.range(2, Math.sqrt(n).toInt+1).reverse.foldLeft(true)((p, d) => p && (n % d != 0))
  }

  def genprimes (range :Int) :Array[Int] = {
    val primes = List.range(0,range).toArray
    primes(1) = 0
    var idx = 2
    while (idx < range) {
      for (midx <- List.range(idx+idx, primes.length, idx)) primes(midx) = 0
      do idx = idx+1
      while (idx < range && primes(idx) == 0)
    }
    return primes
  }

  def trim (name :String) = name.slice(1, name.length-1)
  def readwords (file :String) :List[RichString] = {
    return Source.fromFile(file).getLines.next.split(',').map(trim).toList.sort(_<_)
  }
}
