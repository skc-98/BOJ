#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}

	vector<string> v2 = v;
	sort(v2.begin(), v2.end());
	if (v == v2) {
		cout << "INCREASING";
		return 0;
	}

	vector<string> v3 = v2;
	reverse(v3.begin(), v3.end());
	if (v == v3) {
		cout << "DECREASING";
		return 0;
	}

	cout << "NEITHER";
	return 0;
}