public class BuyAndSellStocksII {
    public BuyAndSellStocksII(){}

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfitVal = 0;
        for(int i = 0; i < prices.length; i++) {
            int val = maxRecurse(prices, i, prices[i]);
            maxProfitVal = Math.max(val, maxProfitVal);
            System.out.println("MAX : " + maxProfitVal);
        }
        return  maxProfitVal;
    }

    public static int maxRecurse(int[] prices, int i, int buy) {
        int maxProfitVal = 0;
        int j = i+1;
        while( j < prices.length) {
            int profit = 0;
            int tempMax = 0;
            if(buy <= prices[j]) {
                profit = prices[j] - buy;
                System.out.println("Buy: " + buy + " vs sell:" + prices[j]);
                int val = maxRecurse(prices, j, prices[j]);
                tempMax = Math.max(val, tempMax);
                System.out.println("Profit margin : " + prices[j] + "-" + buy + " + (RECURSE) " + val);
            }
            maxProfitVal = Math.max(profit + tempMax, maxProfitVal);
            j++;
        }
        return maxProfitVal;
    }
}