#include<iostream>
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
		if (s[i] >= '0' && s[i] <= '9') {
			st.push(s[i]-'0');
		}
		else {
			int second = st.top(); st.pop();
			int first = st.top(); st.pop();
			if (s[i] == '+') {
				st.push(first + second);
			}
			else if (s[i] == '-') {
				st.push(first - second);
			}
			else if (s[i] == '*') {
				st.push(first * second);
			}
			else if (s[i] == '/') {
				st.push(first / second);
			}
		}
	}
	cout << st.top();
	return 0;
}