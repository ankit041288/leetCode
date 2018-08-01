public class RP {
    public static void main(String[] args){
        subarraySum(new int[]{-1,-1,3},3);
    }
    public  static int subarraySum(int[] nums, int k) {
        int i =0;
        int count =0;
        int sum=nums[0];
        int j =1;
        while(j<=nums.length)
        {
            if(sum ==k && i<nums.length){
                count++;
                sum =sum - nums[i];
                i++;
            }
            else if (sum >k && i<nums.length){
                sum = sum-nums[i];
                i++;
            }
            else {
                if(j==nums.length) break;
                sum = sum+nums[j];
                j++;

            }
        }
        return count;
    }
}
