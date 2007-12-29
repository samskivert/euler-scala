object Euler12 extends Application {
  def divisors (x :Int) :List[Int] = {
    List.flatten(for { 
      divis <- List.range(1, Math.sqrt(x)+1)
      if x % divis == 0
    } yield List(divis, x / divis).removeDuplicates);
  }

  var x = 0; var i = 0; var divs = 0;
  while (divs <= 500) {
    i = i + 1;
    x = x + i;
    divs = divisors(x).length;
  }
  println(x);
}
