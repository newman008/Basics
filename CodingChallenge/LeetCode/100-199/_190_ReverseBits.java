package LeetCode2;

import java.util.HashMap;
import java.util.Map;

public class _190_ReverseBits {
    Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
    
    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        byte[] bytes = new byte[4];
        for(int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >> 8*i) & 0xFF);
        }
        int res = 0;
        for(int i = 0; i < 4; i++) {
            res += reverseByte2(bytes[i]);
            if(i < 3) res = res << 8;
        }
        return res;
    }
    
    public int reverseByte2(byte b) {
        Integer value = cache.get(b);
        if(value != null)
            return value;
        value = 0;
        for(int i = 0; i < 8; i++) {
            value += ((b >> i) & 1);
            if(i < 7) value = value << 1;
        }
        cache.put(b, value);
        return value;
    }
    
    public int reverseBits3(int n) {
        for(int i = 0; i < 16; i++) {
            int j = 31 - i;
            int a = (n >> i) & 1;
            int b = (n >> j) & 1;
            if((a ^ b) != 0) {
                n = n ^ ((1 << i) | (1 << j));
            } 
        }
        
        return n;
    }
    
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for(int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >>> i*8) & 0xFF);
        }
        int res = 0;
        for(int i = 0; i < 4; i++) {
            res += reverseByte(bytes[i]);
            if(i < 3)
                res = res << 8;
        }
        
        return res;
    }
    
    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if(value != null) return value;
        
        value = 0;
        for(int i = 0; i < 8; i++) {
            value += b & 1;
            b >>= 1;
            if(i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            _190_ReverseBits t = new _190_ReverseBits();
            t.reverseBits(1);
    }
}
