#include<iostream>
#include<set>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	set<int> st1, st2;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		st1.insert(a);
	}

	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		st2.insert(a);
	}

	int count = 0;
	vector<int> ans;
	for (const auto& i : st1) {
		if (st2.find(i) == st2.end()) {
			count++;
			ans.push_back(i);
		}
	}

	cout << count << '\n';
	for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
	return 0;
}