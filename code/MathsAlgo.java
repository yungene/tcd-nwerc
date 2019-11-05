public class MathsAlgo {
  public static int gcd(int a, int b) {
    if(b>a) {
      int t = a;
      a = b;
      b = t;
    }
    while(b!=0) {
      int t  =b;
      b = a  % b;
      a = t;
    }
    return a;
  }
}
