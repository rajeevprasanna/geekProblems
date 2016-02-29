package arrays

/**
  * Created by rajeevprasanna on 2/28/16.
  */
//Binary search in scala
object p15 extends App {

  def binraySearch[A <% Ordered[A]](xs: List[A], element: A): Int = {
    def _binraySearch(low: Int, high: Int): Int = (low + high) / 2 match {
      case _ if low > high || low > xs.length-1 || high < 0 => -1
      case mid if xs(mid) == element => mid
      case mid if xs(mid) > element =>  _binraySearch(low, mid - 1)
      case mid if xs(mid) < element =>  _binraySearch(mid + 1, high)
    }
    _binraySearch(0, xs.length - 1)
  }

  val xs = List(0, 1, 2, 3, 4, 5, 6, 7, 8)
  xs.map(binraySearch(xs, _)).foreach(println)
}
