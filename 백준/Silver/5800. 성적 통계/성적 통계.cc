#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		vector<int> v;
		for (int j = 0; j < num; j++) {
			int a;
			cin >> a;
			v.push_back(a);
		}
		sort(v.begin(), v.end());
		int largegap = 0;
		for (int j = 1; j < v.size(); j++) {
			int t = v[j] - v[j - 1];
			if (largegap < t) largegap = t;
		}
		cout << "Class " << i << '\n';
		cout << "Max " << v[v.size() - 1] << ", Min " << v[0] << ", Largest gap " << largegap << '\n';
	}
	return 0;
}