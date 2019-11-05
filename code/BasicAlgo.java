
public class BasicAlgo {

  public static int binarySearch(int[] arr, int val) {
    int lo = 0;
    int hi = arr.length;
    int res = -1;
    while(lo<hi) {
      int mid = lo + (hi-lo)/2;
      if(val == arr[mid]) {
        res = mid;
        break;
      }
      if(val<arr[mid]) {
        hi = mid;
      } else if(val>arr[mid]) {
        lo = mid+1;
      }
    }
    return res;
  }
  
  public static int rank(int[] arr, int val) {
    int lo = 0;
    int hi = arr.length;
    int res = -1;
    while(lo<hi) {
      int mid = lo + (hi-lo)/2;
      if(val == arr[mid]) {
        res = mid;
        return res;
      }
      if(val<arr[mid]) {
        hi = mid;
      } else if(val>arr[mid]) {
        lo = mid+1;
      }
    }
    return hi;
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.printf("binarySearch([1,3,5,8,9],1) = %d== 0\n",binarySearch(new int[] {1,3,5,8,9},1));
    System.out.printf("binarySearch([1,3,5,8,9],1) = %d==-1\n",binarySearch(new int[] {1,3,5,8,9},2));
    System.out.printf("rank([1,3,5,8,9],5) = %d==2\n",rank(new int[] {1,3,5,8,9},5));
    System.out.printf("rank([1,3,5,8,9],4) = %d==2\n",rank(new int[] {1,3,5,8,9},4));
    System.out.printf("rank([1,3,5,8,9],-2) = %d==0\n",rank(new int[] {1,3,5,8,9},-2));
    System.out.printf("rank([1,3,5,8,9],16) = %d==5\n",rank(new int[] {1,3,5,8,9},16));
    System.out.printf("rank([1],2) = %d==1\n",rank(new int[] {1},2));
    System.out.printf("rank([1],2) = %d==1\n",rank(new int[] {1},2));
    System.out.printf("rank([],2) = %d==0\n",rank(new int[] {},2));

  }

}
