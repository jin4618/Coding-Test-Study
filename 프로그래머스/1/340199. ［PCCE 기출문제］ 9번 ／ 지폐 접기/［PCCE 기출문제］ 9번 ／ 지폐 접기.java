class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);
        
        while(billMin > walletMin || billMax > walletMax) {
            if(billMax > billMin) {
                billMax = billMax / 2;
            } else {
                billMin = billMin / 2;
            }
            
            int temp = Math.max(billMax, billMin);
            billMin = Math.min(billMax, billMin);
            billMax = temp;
            
            answer++;
        }
        
        return answer;
    }
}