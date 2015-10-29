package LeetCode2;

public class _223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D - B);
        int area2 = (G-E) * (H - F);
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        int overlap = 0;
        if(right > left && top > bottom) overlap = (right - left) * (top - bottom);
        
        return area1 + area2 - overlap;
    } 
}
