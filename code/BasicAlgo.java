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
}
