package ArraysAndStrings;

/*
 * Write a method to replace all spaces in a string with '%20'
 * "hello world" => "hello%20world"
 */

public class _14 {
    
    public void replaceSpaces(char[] str, int length) {
        int newLength = length;
        for(int i = 0; i < length; i++){
            if(str[i] == ' ') newLength += 2;
        }
        
        str[newLength] = '\0';
        
        for(int i = length - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
