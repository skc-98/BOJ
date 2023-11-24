#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v(n + 1);
	vector<int> v2(n + 1);
	int dis = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v[i] = a;
		dis += (abs(a - v[i - 1]));
		v2[i] = dis;
	}

	for (int i = 1; i <= m; i++) {
		int a, b;
		cin >> a >> b;
		cout << v2[b] - v2[a] << '\n';
	}
	return 0;
}