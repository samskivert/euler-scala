object Euler31 extends Application {
  def perms (remain :Int, coins :List[Int]) :Int = {
    if (remain == 0) return 1;
    else if (coins == Nil) return 0;
    else List.range(0, remain/coins.head+1).map(
      q => perms(remain - q*coins.head, coins.tail)).foldRight(0)(_+_);
  }
  println(perms(200, List(200, 100, 50, 20, 10, 5, 2, 1)));
}
