class Solution {
    public String solution(String new_id) {
        // 1단계 : 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2단계 : 허용 x 문자 제거 => 소문자, 숫자, -, _, . 만 사용 가능
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계 : 연속된 마침표 => 하나로
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계 : 처음과 끝에 있는 마침표 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        // 5단계 : 빈 문자열 => "a"
        if(new_id.isEmpty()) {
            new_id = "a";
        }
        
        // 6단계 : 길이 16자 이상 => 15자로 자르고 끝에 있는 마침표 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        
        // 7단계 : 길이 2자 이하 => 마지막 문자로
        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}