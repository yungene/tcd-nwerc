
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
      } else {
        int tm = (tl+tr)/2;
        if(r<=tm) {
          return sum(2*i,tl,tm,l,r);
        } else if (l > tm) {
          return sum(2*i+1,tm+1,tr,l,r);
        } else {
            int ls = sum(2*i,tl,tm,l,tm);
            int rs = sum(2*i+1,tm+1,tr,tm+1,r);
            return ls + rs;
        } 
      }
    } 
    
    void update(int pos, int newVal) {
      update(1,0,n-1,pos,newVal);
      
    }   
    // up
    private void update(int i, int tl, int tr, int pos, int newVal) {
      if(tl==tr) {
        tree[i]=newVal;
      }else {
        int tm = (tl+tr)/2;
        if(pos<=tm) {
          update(i*2,tl,tm,pos,newVal);
        } else {
          update(i*2+1,tl,tm,pos,newVal);
        }
        tree[i] = tree[2*i] + tree[2*i+1];
      }
    }
    
  }

}
