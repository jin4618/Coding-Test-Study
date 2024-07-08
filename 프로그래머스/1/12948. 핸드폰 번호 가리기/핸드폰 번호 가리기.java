class Solution {
    public String solution(String phone_number) {
        int size = phone_number.length() - 4;
        
        String last = phone_number.substring(size);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < size; i++) {
            sb.append("*");
        }
        
        return sb.toString().concat(last);
    }
}