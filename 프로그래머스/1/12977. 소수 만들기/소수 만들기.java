class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for(int i = 0; i < len - 2; i++) {
            for(int j = i + 1; j < len - 1; j++) {
                for(int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    boolean check = true;
                    if(sum < 2) check = false;
                    
                    for(int n = 2; n <= Math.sqrt(sum); n++) {
                        if(sum % n == 0) {
                            check = false;
                            break;
                        }
                    }
                    
                    if (check) answer++;
                    
                }
            }
        }

        return answer;
    }
}