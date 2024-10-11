import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pokemonTypes = new HashSet<>();
        
        for (int num : nums) {
            pokemonTypes.add(num);
        }
        
        int select = nums.length / 2;
        
        return Math.min(pokemonTypes.size(), select);
    }
}