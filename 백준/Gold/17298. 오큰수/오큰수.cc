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

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	vector<int> v2(n);
	stack<int> st;
	for (int i = n - 1; i >= 0; i--) {
		while (!st.empty() && st.top() <= v[i]) {
			st.pop();
		}
		if (st.empty()) v2[i] = -1;
		else {
			v2[i] = st.top();
		}
		st.push(v[i]);
	}

	for (int i = 0; i < v2.size(); i++) cout << v2[i] << " ";
	return 0;
}