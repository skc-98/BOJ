#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int count = 0;
	vector<stack<int>> v(200001);
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		if (v[a].empty() && b == 1) v[a].push(b);
		else if (v[a].empty() && b == 0) count++;
		else if (!v[a].empty() && b == 1) count++;
		else if (v[a].top() == 1 && b == 0) v[a].pop();
	}

	for (int i = 0; i < 200001; i++) {
		if (!v[i].empty()) count += v[i].size();
	}
	cout << count;
	return 0;
}