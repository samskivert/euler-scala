object Euler19 extends Application {
  def norm (days :Int) :Function1[Int,Int] = ((year :Int) => (days));
  def leap (days :Int) :Function1[Int,Int] = ((year :Int) => {
    if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) days+1;
    else days;
  });
  val length = Array(norm(31), leap(28), norm(31), norm(30), norm(31), norm(30),
                     norm(31), norm(31), norm(30), norm(31), norm(30), norm(31));

  println((for (year <- List.range(1900, 2001); month <- List.range(0, 12))
           yield Pair(year, month)).foldLeft(Pair(0, 0))(
             (acc :Pair[Int,Int], cur :Pair[Int,Int]) => (
               Pair(if (cur._1 > 1900 && acc._2 % 7 == 6) 1+acc._1 else acc._1,
                    acc._2 + length(cur._2)(cur._1))))._1);
}
