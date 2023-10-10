#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int a = n;
	vector<int> v;
	while (1) {
		if (a / m == 0) break;
		v.push_back(a % m);
		a /= m;
	}
	v.push_back(a);
	string res = "";
	for (int i = v.size() - 1; i >= 0; i--) {
		if (v[i] < 10) res += to_string(v[i]);
		else res += (char)(v[i] + 55);
	}
	cout << res;
	return 0;
}