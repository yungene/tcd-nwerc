// return the prefix function
private static int[] KMPpre(final String P) {
 final int n = P.length();
 final int[] pi = new int[n];
 pi[0] = 0;
 int k = 0;
 for (int q = 1; q < n; q++) {
  while (k > 0 && P.charAt(k) != P.charAt(q)) {
   k = pi[k - 1];
  }
  if (P.charAt(k) == P.charAt(q)) {
   k++;
  }
  pi[q] = k;
 }
 return pi;
}

public static Pair<Integer, ArrayList<Integer>> KMP(final String haystack, final String needle) {
 final int m = haystack.length();
 final int n = needle.length();
 final int[] pi = KMPpre(needle);
 int q = 0;
 int count = 0;
 ArrayList<Integer> resArr = new ArrayList<>();
 for (int i = 0; i < m; i++) {
  while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
   q = pi[q - 1];
  }
  if (haystack.charAt(i) == needle.charAt(q)) {
   q++;
  }
  if (q == n) {
   count++;
   resArr.add(i + 1 - n);
   q = pi[q - 1];
  }
 }
 return new Pair<Integer, ArrayList<Integer>>(count, resArr);
}