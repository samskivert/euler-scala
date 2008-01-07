object Euler21 extends Application {
  def sum (values :List[Int]) = {
    values.foldLeft(0)(_+_)
  }

  def divisors (x :Int) :List[Int] = {
    1 :: List.flatten(for { 
      divis <- List.range(2, Math.sqrt(x)+1)
      if x % divis == 0
    } yield List(divis, x / divis).removeDuplicates);
  }

  println(sum(for {
    a <- List.range(1, 10000)
    da <- List(sum(divisors(a)))
    dda <- List(sum(divisors(da)))
    if (a == dda && a != da && da < 10000)
  } yield a));
}
