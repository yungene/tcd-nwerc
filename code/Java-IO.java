static class Reader {
    BufferedReader br;
    StringTokenizer st;

    public Reader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (st == null || !st.hasMoreTokens()) {
        st = new StringTokenizer(nextLine());
      }
      return st.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      String str = "";
      str = br.readLine();
      return str;
    }
  }
  static Reader reader = new Reader();