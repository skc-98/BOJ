#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	stack<int> st;
	for (int i = 0; i < s.length(); i++) {
		if (st.empty()) {
			st.push(s[i]);
			continue;
		}
		else if (st.top() == '(') {
			if (s[i] == '(') st.push(s[i]);
			else st.pop();
		}
		else if (st.top() == ')') st.push(s[i]);
	}
	cout << st.size();
	return 0;
}