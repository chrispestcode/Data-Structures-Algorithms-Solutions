public class FirstAndLastInSortedArray {

    public static void main(String[] args) {
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {1,2,3,3,3,3,4,5,9};
        //int[] nums = {1,1};
        searchRange(nums, 3);
    }
        public static int[] searchRange(int[] nums, int target) {
            int[] ep = {-1, -1};
            bs(nums,target,ep,0,nums.length-1);
            //binary search on target;
            //pt 1 do binary search for target with the smallest index
            //pt 2 do binary search for target with the largest index
            System.out.println("EPS : " + ep[0] + "; " + ep[1]);
            return ep;

        }

        public static void bs(int[] nums, int target, int[] ep, int st, int ed) {
            int mp = st + (ed-st)/2;
            System.out.println("MP : " + mp);
            if(ed - st < 0) return;
            if(nums[mp] == target) {
                if(mp > ep[1] || ep[1] == -1) {
                    ep[1] = mp;
                    System.out.println("Greater mp : " + ep[1]);
                    bs(nums,target,ep,mp+1, ed);

                }
                if(mp < ep[0] || ep[0] == -1) {
                    ep[0] = mp;
                    System.out.println("Lesser mp : " + ep[0]);
                    bs(nums,target,ep, st, mp-1);
                }

            }
            System.out.println("pts " + ep[0] + " :" + ep[1]);
            if(nums[mp] > target) {
                bs(nums,target,ep, st, mp-1);
            } else if (nums[mp] < target ) {
                bs(nums,target,ep,mp+1, ed);
                System.out.println("OVerflow?");
            }
            System.out.println("Finished");
        }
}
