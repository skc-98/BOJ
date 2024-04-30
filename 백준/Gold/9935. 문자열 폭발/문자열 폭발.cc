#include<iostream>
#include<stack>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s, bomb;
	cin >> s;
	cin >> bomb;

	stack<char> st;
	for (long unsigned int i = 0; i < s.length(); i++) {
		st.push(s[i]);
		if (st.size() >= bomb.length()) {
			bool a = true;
			stack<char> st2;
			for (int j = bomb.length() - 1; j >= 0; j--) {
				if (st.top() != bomb[j]) {
					a = false;
					break;
				}
				st2.push(st.top());
				st.pop();
			}
			if (a == true) {
				while (!st2.empty()) st2.pop();
			}
			else {
				while (!st2.empty()) {
					st.push(st2.top());
					st2.pop();
				}
			}
		}
	}
	
	string ans = "";
	if (st.empty() == true) cout << "FRULA";
	else {
		while (!st.empty()) {
			ans += st.top();
			st.pop();
		}
		reverse(ans.begin(), ans.end());
		cout << ans;
	}
	return 0;
}