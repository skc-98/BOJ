#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int maxlen = 0;
	vector<int> v;
	vector<int> v2;
	
	for (int i = n; i >= 1; i--) {
		v.push_back(n);
		v.push_back(i);
		while (1) {
			if (v[v.size() - 2] - v[v.size() - 1] < 0) {
				if (maxlen < v.size()) {
					maxlen = v.size();
					v2.assign(v.begin(), v.end());
				}
				break;
			}
			v.push_back(v[v.size() - 2] - v[v.size() - 1]);
		}
		v.clear();
	}

	cout << maxlen << '\n';
	for (int i = 0; i < v2.size(); i++) {
		cout << v2[i] << " ";
	}

	return 0;
}