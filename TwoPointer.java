public class TwoPointer {

    static int removeDuplicates(int[] arr) {
        int left = 1, right = 1;
        while (right < arr.length) {
            if (arr[right] != arr[left - 1]) {
                arr[left] = arr[right];
                left++;
            }
            right++;
        }
        for(int i=0; i<left;i++){
            System.out.println(arr[i]);
        }
        return left;
    }

    static int[] twoSum(int[] arr,int target){
        int left = 0, right = arr.length-1;
        while(left!=right){
            if(arr[left]+arr[right]==target){
                return new int[] {left,right};
            }
            else if(arr[left]+arr[right]<target){
                left++;
            } else {
                right--;
        }
    }
        return new int[] {-1,-1};
    }

    static int maxArea(int[] heights) {
        int left =0,right = heights.length-1;
        int area = 0,maxArea = 0,width = 0;
        while(left <= right){
            width = right - left;
            area = Math.min(heights[right],heights[left]) * width;
            maxArea = Math.max(area,maxArea);
            if(heights[left]<heights[right])
            left++;
            else
            right--;  
        }
        return maxArea;
    }

    static int[] reverseArray(int[] arr){
        int left = 0, right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    static int[] moveZeroes(int[] arr){
        int left = 0, right = 0;
        while(right < arr.length){
            if(arr[right] != 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
        return arr;
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }

    static boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        //removeDuplicates
        // int[] a = { 1, 1, 2, 2, 3, 3, 3, 4 };
        // System.out.println(removeDuplicates(a));

        //twoSum
        // int[] a1 = {2,7,11,15};
        // int target = 9;
        // int[] result = twoSum(a1, target);
        // System.out.println(result[0]+"," + result[1]);

        //maxArea
        // int[] heights = {1,7,2,5,4,7,3,6};
        // System.out.println(maxArea(heights));

        // //reverseArray
        // int[] a2 = {1,2,3,4,5};
        // int[] result = reverseArray(a2);
        // for(int num : result) 
        //     System.out.print(num + " ");  

        //moveZeroes
         int[] a3 = {0,1,0,3,12};
         int[] result = (moveZeroes(a3));
         for(int num : result) 
             System.out.print(num + " ");
    }

}
