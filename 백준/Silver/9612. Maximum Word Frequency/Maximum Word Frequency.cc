#include<iostream>
#include<vector>
#include<string>
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
	sort(v.begin(), v.end());

	string maxitem = v[0];
	int max = 0;
	int count = 0;
	for (int i = 0; i < v.size() - 1; i++) {
		if (v[i] == v[i + 1]) count++;
		else if (v[i] != v[i + 1]) {
			count++;
			if (max <= count) {
				maxitem = v[i];
				max = count;
			}
			count = 0;
		}
	}
	if (count != 0) {
		count++;
		if (max <= count) {
			maxitem = v[v.size() - 1];
			max = count;
		}
	}
	cout << maxitem << " " << max;
	return 0;
}