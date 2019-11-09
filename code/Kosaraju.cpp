// 1.For each vertex u of the graph, mark u as unvisited. Let L be empty.
// 2.For each vertex u of the graph do Visit(u), where Visit(u) is the recursive subroutine:
//   If u is unvisited then:
//       Mark u as visited.
//       For each out-neighbour v of u, do Visit(v).
//       Prepend u to L.
//   Otherwise do nothing.
// 3.For each element u of L in order, do Assign(u,u) where Assign(u,root) is the recursive subroutine:
//   If u has not been assigned to a component then:
//       Assign u as belonging to the component whose root is root.
//       For each in-neighbour v of u, do Assign(v,root).
//   Otherwise do nothing.
vi adj[N], adjt[N];
int n, ordn, cnt, vis[N], ord[N], cmp[N];

void dfs(int x) {
  vis[x] = 1;
  for (auto v : adj[x]) if (!vis[v]) dfs(v);
  ord[ordn++] = x;
}

void dfst(int x) {
  cmp[x] = cnt, vis[x] = 0;
  for (auto v : adjt[u]) if (vis[v]) dfst(v);
}

// in main
for (int i = 1; i <= n; ++i) if (!vis[i]) dfs(i);
for (int i = ordn-1; i >= 0; --i) if (vis[ord[i]]) cnt++, dfst(ord[i]);