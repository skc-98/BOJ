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
	bool check = false;
	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') {
			st.push(s[i]);
			check = true;
		}
		else {
			if (check == true) {
				st.pop();
				ans += st.size();
			}
			else {
				st.pop();
				ans += 1;
			}
			check = false;
		}
	}
	cout << ans;
	return 0;
}