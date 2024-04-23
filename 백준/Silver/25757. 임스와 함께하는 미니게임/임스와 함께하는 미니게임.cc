#include<iostream>
#include<set>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n; char c;
	cin >> n >> c;

	set<string> st;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		st.insert(s);
	}

	if (c == 'Y') cout << st.size();
	else if (c == 'F') cout << st.size() / 2;
	else if (c == 'O') cout << st.size() / 3;

	return 0;
}