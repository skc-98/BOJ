#include<iostream>
#include<stack>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	for (int i = 0; i < n; i++) {
		stack<char> st;
		string s;
		cin >> s;
		for (int j = 0; j < s.length(); j++) {
			if (st.empty() == false && st.top() == s[j]) {
				st.pop();
				continue;
			}
			else st.push(s[j]);
		}
		if (st.empty()) ans++;
	}
	cout << ans;
	return 0;
}