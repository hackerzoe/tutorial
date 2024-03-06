#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define ppll pair<pll, pll>
#define x first
#define y second
#define z third

ll num[200200] = {};
pair<pll, pll> tree[800800] = {};

void init(int s, int e, int node){
	if(s == e){
		tree[node] = {{num[s], 1}, {0, 0}};
		return;
	}
	int m = (s + e) / 2;
	init(s, m, node * 2);
	init(m + 1, e, node * 2 + 1);
	ppll p = tree[node * 2];
	ppll q = tree[node * 2 + 1];
	if(p.x.x == q.x.x){
		if(p.y.x == q.y.x) tree[node] = {{p.x.x, p.x.y + q.x.y}, {p.y.x, p.y.y + q.y.y}};
		else if(p.y.x > q.y.x) tree[node] = {{p.x.x, p.x.y + q.x.y}, p.y};
		else tree[node] = {{p.x.x, p.x.y + q.x.y}, q.y};
	}
	else{
		if(min(p.x.x, q.x.x) > max(p.y.x, q.y.x)) 
		tree[node] = {max(p.x, q.x), max(min(p.x, q.x), max(p.y, q.y))};
	}
}

void update(int s, int e, int node, int t, int d){
	if(s > t || t > e) return;
	if(s == e){
		tree[node] = {d, 0};
		return;
	}
	int m = (s + e) / 2;
	update(s, m, node * 2, t, d);
	update(m + 1, e, node * 2 + 1, t, d);
	pll p = tree[node * 2];
	pll q = tree[node * 2 + 1];
	if(p.x == q.x){
		tree[node] = {p.x, max(p.y, q.y)};
	}
	else{
		tree[node] = {max(p.x, q.x), max(min(p.x, q.x), max(p.y, q.y))};
	}
}

pll find(int s, int e, int node, int l, int r){
	if(r < s || e < l) return {0, 0};
	else if(l <= s && e <= r) return tree[node];
	else{
		int m = (s + e) / 2;
		pll p = find(s, m, node * 2, l, r);
		pll q = find(m + 1, e, node * 2 + 1, l, r);
		if(p.x == q.x){
			return {p.x, max(p.y, q.y)};
		}
		else{
			return {max(p.x, q.x), max(min(p.x, q.x), max(p.y, q.y))};
		}
	}
}

int main(){
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	ll n, q;
	cin >> n >> q;
	for(int i = 0 ; i < n ; i ++){
		cin >> num[i];
	}
	init(0, n - 1, 1);
	for(int i = 0 ; i < q ; i ++){
		ll a, b, c;
		cin >> a >> b >> c;
		if(a == 1){
			update(0, n - 1, 1, b - 1, c);
		}
		else{
			pll ans = find(0, n - 1, 1, b - 1, c - 1);
			cout << ans.y << "\n";
		}
	}

	return 0;
}
