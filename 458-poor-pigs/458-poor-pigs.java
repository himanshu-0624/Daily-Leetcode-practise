class Solution {
    public int poorPigs(int bc, int md, int mt) {
        int r = mt/md;
        int p = 0;
        while(Math.pow(r+1,p) < bc)
            p++;
        return p;
    }
}