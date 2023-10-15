#include<iostream>
#include<vector>
using namespace std;

int gcd(const int& a, const int& b) {
	if (b == 0) return a;
	else return gcd(b, a % b);
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
	vector<int> v2;
	for (int i = 0; i < v.size() - 1; i++) {
		v2.push_back(v[i + 1] - v[i]);
	}
	int gans = v2[0];
	for (int i = 1; i < v2.size(); i++) {
		gans = gcd(gans, v2[i]);
	}
	int ans = 0;
	for (int i = 0; i < v2.size(); i++) {
		ans += ((v2[i] / gans) - 1);
	}
	cout << ans;
	return 0;
}