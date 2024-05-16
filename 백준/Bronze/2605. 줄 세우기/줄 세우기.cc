#include<iostream>
#include<stack>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	stack<int> st;
	for (int i = 1; i <= n; i++) {
		stack<int> st2;
		int a;
		cin >> a;
		if (i == 1) {
			st.push(1);
			continue;
		}
		for (int j = 0; j < a; j++) {
			st2.push(st.top());
			st.pop();
		}
		st.push(i);
		while (1) {
			if (st2.empty()) break;
			st.push(st2.top());
			st2.pop();
		}
	}
	vector<int> v;
	while (!st.empty()) {
		v.push_back(st.top());
		st.pop();
	}
	for (int i = v.size() - 1; i >= 0; i--) cout << v[i] << " ";
	return 0;
}