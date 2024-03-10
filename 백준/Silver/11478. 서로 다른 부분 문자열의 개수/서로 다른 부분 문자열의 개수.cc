#include<iostream>
#include<string>
#include<set>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	
	set<string> st;
	for (int i = 1; i <= s.length(); i++) {
		for (int j = 0; j + i <= s.length(); j++) {
			st.insert(s.substr(j, i));
		}
	}

	cout << st.size();
	return 0;
}