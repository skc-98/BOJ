#include<iostream>
#include<unordered_set>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	unordered_set<string> st;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		st.insert(a);
	}

	for (int i = 0; i < m; i++) {
		string a;
		cin >> a;

		string ss = "";
		for (int j = 0; j < a.length(); j++) {
			if (a[j] == ',') {
				st.erase(ss);
				ss = "";
				continue;
			}
			ss += a[j];
		}
		if (!ss.empty()) st.erase(ss);
		cout << st.size() << '\n';
	}

	return 0;
}