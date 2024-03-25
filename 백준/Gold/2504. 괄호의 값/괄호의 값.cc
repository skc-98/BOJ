#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);

	int answer = 0;
	int num = 1;
	stack<char> st;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') {
			num *= 2;
			st.push(s[i]);
		}
		else if (s[i] == '[') {
			num *= 3;
			st.push(s[i]);
		}
		else if (s[i] == ')') {
			if (st.empty() == true || st.top() != '(') {
				cout << 0;
				return 0;
			}
			st.pop();
			if (s[i - 1] == '(') answer += num;
			num /= 2;
		}
		else if (s[i] == ']') {
			if (st.empty() == true || st.top() != '[') {
				cout << 0;
				return 0;
			}
			st.pop();
			if (s[i - 1] == '[') answer += num;
			num /= 3;
		}
	}
	if (st.empty() == false) {
		cout << 0;
		return 0;
	}
	cout << answer;
	return 0;
}