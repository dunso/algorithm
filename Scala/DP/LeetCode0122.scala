import sun.applet.Main

object LeetCode0122 {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices == null || prices.length < 2) 0 else {
      var max = 0
      for (i <- 1 until prices.length) {
        if (prices(i) > prices(i - 1)) {
          max += prices(i) - prices(i - 1);
        }
      }
      max
    }
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(1, 2, 3, 4, 5)))
  }
}