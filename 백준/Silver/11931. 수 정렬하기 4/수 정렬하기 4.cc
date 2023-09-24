#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(int n, int m) {
	return n > m;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
	return 0;
}