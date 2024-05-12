#include<iostream>
#include<string>
#include<stack>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	string s;
	cin >> n;
	cin >> s;

	vector<double> v;
	for (int i = 0; i < n; i++) {
		double a;
		cin >> a;
		v.push_back(a);
	}

	stack<double> st;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') {
			st.push(v[s[i] - 'A']);
		}
		else {
			double a = st.top();
			st.pop();
			double b = st.top();
			st.pop();
			if (s[i] == '+') st.push(b + a);
			else if (s[i] == '-') st.push(b - a);
			else if (s[i] == '*') st.push(b * a);
			else if (s[i] == '/') st.push(b / a);
		}
	}
	cout << fixed;
	cout.precision(2);
	cout << st.top();
	return 0;
}