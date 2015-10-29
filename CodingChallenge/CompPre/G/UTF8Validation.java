package InterviewQuestions;

public class UTF8Validation {
    
    public boolean isValidChar(byte[] bytes) {
        int expectedLen = 0;
        if(bytes.length == 0) return false;
        else if((bytes[0] & 0b10000000) == 0b00000000) expectedLen = 1;
        else if((bytes[0] & 0b11100000) == 0b11000000) expectedLen = 2;
        else if((bytes[0] & 0b11110000) == 0b11100000) expectedLen = 3;
        else if((bytes[0] & 0b11111000) == 0b11110000) expectedLen = 4;
        else if((bytes[0] & 0b11111100) == 0b11111000) expectedLen = 5;
        else if((bytes[0] & 0b11111110) == 0b11111100) expectedLen = 6;
        else return false;
        if(bytes.length != expectedLen) return false;
        
        for(int i = 1; i < expectedLen; i++) {
            if((bytes[i] & 0b11000000) != 0b10000000) return false;
        }
        
        return true;
    }
    
    public static int charLength(byte[] bytes) {
        int charCount = 0;
        int expectedLen = 0;
        for(int i = 0; i < bytes.length; i++) {
            charCount++;
            if((bytes[i] & 0b10000000) == 0b00000000) continue;
            else if((bytes[i] & 0b11100000) == 0b11000000) expectedLen = 2;
            else if((bytes[i] & 0b11110000) == 0b11100000) expectedLen = 3;
            else if((bytes[i] & 0b11111000) == 0b11110000) expectedLen = 4;
            else if((bytes[i] & 0b11111100) == 0b11111000) expectedLen = 5;
            else if((bytes[i] & 0b11111110) == 0b11111100) expectedLen = 6;
            else return -1;
            
            while(--expectedLen > 0) {
                if(++i >= bytes.length) return -1;
                if((bytes[i] & 0b11000000) != 0b10000000) return -1;
            }
            
        }
        
        return charCount;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UTF8Validation u = new UTF8Validation();
        byte[] bytes1 = {(byte)0b11001111, (byte)0b10111111};
        System.out.println(u.isValidChar(bytes1));
    }

}
