#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(const string& a, const string& b) {
	if (a.length() != b.length()) {
		return a.length() < b.length();
	}
	else {
		int asum = 0;
		for (int i = 0; i < a.length(); i++) {
			if (isdigit(a[i])) asum += a[i] - '0';
		}
		int bsum = 0;
		for (int i = 0; i < b.length(); i++) {
			if (isdigit(b[i])) bsum += b[i] - '0';
		}
		if (asum != bsum) {
			return asum < bsum;
		}
		return a < b;
	}
}

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

	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
	return 0;
}