class Solution {
    public int reverse(int x) {
        // convert to array
        char[] numChars = Integer.toString(x).toCharArray();
        
        int left = numChars[0] == '-' ? 0 : 1;
        int right = numChars.length - 1;
        
        while(left < right){
            char swapRight = numChars[left];
            char swapLeft = numChars[right];
            numChars[left] = swapLeft;
            numChars[right] = swapRight;
            
            left++;
            right--;
        }
        
        return Integer.parseInt(String.valueOf(numChars));
        
    }
}
