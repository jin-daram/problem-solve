class Solution {
    
    public static int[] numbers;
    public static int count = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        dfs(0, 0, target);
        return count;
    }

    public void dfs(int index, int result, int target) {
        if (index == numbers.length) {
            if (result == target) count++;
            return;
        }
        dfs(index+1, result + numbers[index], target);
        dfs(index+1, result + (-numbers[index]), target);
    }
}