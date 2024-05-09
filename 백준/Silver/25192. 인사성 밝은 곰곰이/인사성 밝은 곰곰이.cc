#include<iostream>
#include<string>
#include<set>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ans = 0;
	set<string> st;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		if (s == "ENTER") {
			ans += st.size();
			st.clear();
		}
		else st.insert(s);
	}
	ans += st.size();
	cout << ans;
	return 0;
}