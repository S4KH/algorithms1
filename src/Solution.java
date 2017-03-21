public class Solution {
    static int findMin(int startI, int[] prices){
        int curr = prices[startI-1];
        for(int i=startI;i<prices.length;i++){
            if(curr>=prices[i]){
                return prices[i];
            }
        }
        return 0;
    }
    
    static void finalPrice(int[] prices) {
        int finalPrice = 0;
        int[]dc = new int[prices.length];        
        StringBuilder nonDcIdx = new StringBuilder();
        for(int i=0;i<prices.length;i++){
            int min = i+1 < prices.length ? findMin(i+1, prices) : 0;
            dc[i]=min;
            if(min==0){
                nonDcIdx.append(i+" ");
            }
            finalPrice+=(prices[i]-dc[i]);
        }
        System.out.println(finalPrice);
        System.out.println(nonDcIdx.toString().trim());
    }

    public static void main(String[] args) {
        finalPrice(new int[] { 5, 1,3,4,6,2});
//        finalPrice(new int[] { 1,3,3,2,5});
    }
}
