
public class SegmentTree {
  static public class SegmentSumTree{
    // store root at i=1; left child at 2*i, and right child at 2*i+1
    // Sum function can be replaced by any other associative function
    int n;
    int[] tree;
    
    SegmentSumTree(int n){
      this.tree = new int[4*n];
      this.n=n;
    }
    
    void build(int[] arr) {
      build(arr,1,0,n-1);
    }
    
    private void build(int[] arr, int i, int tl, int tr) {
      if(tl==tr) {
        tree[i]=arr[tl];
      } else {
        int tm = (tl+tr)/2;
        build(arr,i*2,tl,tm);
        build(arr,i*2+1,tm+1,tr);
        tree[i] = tree[2*i] + tree[2*i+1]; 
      }
    }
    // get the sum from arr[l] to arr[r]
    int sum(int l, int r) {
      return sum(1,0,n-1,l,r);
    }
    
    private int sum(int i, int tl, int tr, int l, int r) {
      if(l > r) {
        return 0;
      }
      if(tl == l && tr == r) {
        return tree[i];
      } 
      int tm = (tl + tr) / 2;
        return sum(i*2, tl, tm, l, Math.min(r, tm))
               + sum(i*2+1, tm+1, tr, Math.max(l, tm+1), r);
    } 
    
    void update(int pos, int newVal) {
      update(1,0,n-1,pos,newVal);
    }   
    private void update(int i, int tl, int tr, int pos, int newVal) {
      if(tl==tr) {
        tree[i]=newVal;
      }else {
        int tm = (tl+tr)/2;
        if(pos<=tm) {
          update(i*2,tl,tm,pos,newVal);
        } else {
          update(i*2+1,tm+1,tr,pos,newVal);
        }
        tree[i] = tree[2*i] + tree[2*i+1];
      }
    }
  }
}
