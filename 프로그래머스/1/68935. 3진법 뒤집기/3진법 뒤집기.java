class Solution {
    public int solution(int n) {
        int answer = 0;
        String base = "";
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            base = (n % 3) + base;
            n /= 3;
        }

        base = sb.append(base).reverse().toString();

        answer = Integer.parseInt(base, 3);

        return answer;
    }
}