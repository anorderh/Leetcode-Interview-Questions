class LeetcodesSolution {

    /**
     * "Peak Valley approach" by Leetcode, involves identifying correlated valleys and peaks of "prices" constant
     * fluctuations, and recording the difference. Far moe efficient than "brute force" approach as complexity is only
     * O(N)
     *
     * @param prices
     * @return
     */
    public int maxProfitPeak(int[] prices) {

        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }

        return maxprofit;
    }

    /**
     * "Simple One Pass", operates off logic as "Peak Valley approach" but instead of recording peaks and valleys, it
     * just iterates through the entire Array and adds onto the totalProfit when a price increases after a day. Oh my
     * goodness, this is surprisingly simple and it hurts.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
