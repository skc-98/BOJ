#include<iostream>
#include<stack>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int star;
	int ans = 0;
	stack<int> st;
	
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '*') {
			star = i;
			break;
		}
	}

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') st.push(i);
		else if (s[i] == ')') {
			if (!st.empty() && st.top() < star) {
				st.pop();
				if (i > star) {
					ans++;
				}
			}
			else if (!st.empty()) st.pop();
		}
	}
	cout << ans;
	return 0;
}