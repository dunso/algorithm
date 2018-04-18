object Solution {
      def maxProfit(prices: Array[Int]): Int = {
        if(prices == null || prices.length < 2) 0 
        else{
            var max = 0
            var min = prices(0)
            for(num <- prices){
                max = max max (num - min)
                min = min min num
            }
            max
        }
    }

    def main(args: Array[String]): Unit = {
        println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
    }
}