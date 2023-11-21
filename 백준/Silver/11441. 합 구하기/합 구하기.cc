#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	int sum = 0;
	vector<int> v(n + 1);
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sum += a;
		v[i] = sum;
	}

	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int a, b;
		cin >> a >> b;
		if (a == 1) cout << v[b] << '\n';
		else cout << v[b] - v[a - 1] << '\n';
	}

	return 0;
}