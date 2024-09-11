#include<iostream>
#include<stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	long long ans = 0;
	stack<long long> st;
	for (int i = 0; i < n; i++) {
		long long a;
		cin >> a;
		if (st.empty()) {
			st.push(a);
			continue;
		}
		while (1) {
			if (st.empty()) break;
			if (st.top() > a) break;
			st.pop();
		}
		ans += st.size();
		st.push(a);
	}
	cout << ans;
	return 0;
}