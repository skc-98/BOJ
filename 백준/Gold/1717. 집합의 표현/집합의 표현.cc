#include<iostream>
#include<vector>
using namespace std;

int getp(vector<int>& v, int n) {
	if (v[n] == n) return n;
	return v[n] = getp(v, v[n]);
}

void union_find(vector<int>& v, int a, int b) {
	a = getp(v, a);
	b = getp(v, b);
	if (a < b) v[b] = a;
	else v[a] = b;
}

bool findp(vector<int>& v, int a, int b) {
	a = getp(v, a);
	b = getp(v, b);
	if (a == b) return 1;
	return 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v(n + 1);
	for (int i = 0; i <= n; i++) v[i] = i;
	for (int i = 0; i < m; i++) {
		int order, a, b;
		cin >> order >> a >> b;
		if (order == 0) {
			union_find(v, a, b);
		}
		else if (order == 1) {
			bool ans = findp(v, a, b);
			if (ans) cout << "YES" << '\n';
			else cout << "NO" << '\n';
		}
	}

	return 0;
}