#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> v2;
void backtracking(int curr, const vector<int>& v, int n, int m) {
	if (v2.size() == m) {
		for (int i = 0; i < v2.size(); i++) cout << v2[i] << " ";
		cout << '\n';
		return;
	}
	for (int i = curr; i < n; i++) {
		v2.push_back(v[i]);
		backtracking(i, v, n, m);
		v2.pop_back();
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int  n, m;
	cin >> n >> m;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	backtracking(0, v, n, m);
	return  0;
}