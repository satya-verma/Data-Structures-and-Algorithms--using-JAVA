package data_structures.arrays.reverse_string;

/*  ................  Reverse A String .................*/
// create a function that reverse a string:
// example: "Hello World" becomes "dlroW olleH"

public class ReverseString {
    // reverse method 1
    private String reverse(String string) {
        String temp = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            temp += (string.charAt(i));
        }
        return temp;
    }

    //reverse method 2
    private String reverse2(String string) {
        StringBuilder temp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }
        return temp.toString();
    }

    //reverse method 3
    private String reverse3(String str){
        char[] myArray = str.toCharArray();
        int left, right = 0;
        right = myArray.length - 1;
 
        for (left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = myArray[left];
            myArray[left] = myArray[right];
            myArray[right] = temp;
        }

        String outputString= String.valueOf(myArray);
        return outputString;
    }

    public static void main(String[] args) {
        // lets run our functions
        String greet = "Hello World";
        ReverseString reverseString = new ReverseString();
        
        System.out.println(reverseString.reverse(greet));
        System.out.println(reverseString.reverse2(greet));
        System.out.println(reverseString.reverse3(greet));

        
    }


}
