import scala.io.Source;
import scala.runtime.RichString;

class EulerApp extends Application {
  def isprime (n :Int) :Boolean = {
    List.range(2, Math.sqrt(n).toInt+1).foldRight(true)((d, p) => p && (n % d != 0))
  }

  def genprimes (range :Int) :Array[Int] = {
    val primes = List.range(0,range).toArray;
    primes(1) = 0;
    var idx = 2;
    while (idx >= 0) {
      var prime = primes(idx);
      var midx = idx + prime;
      while (midx < primes.length) {
        primes(midx) = 0;
        midx += prime;
      }
      val nidx = primes.slice(idx+1, primes.length).findIndexOf((a) => (a != 0));
      if (nidx == -1) idx = -1 else idx = idx + 1 + nidx;
    }
    return primes;
  }

  def trim (name :String) = name.slice(1, name.length-1);
  def readwords (file :String) :List[RichString] = {
    return Source.fromFile(file).getLine(0).split(',').map(trim).toList.sort(_<_);
  }
}
