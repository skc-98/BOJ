#include<iostream>
#include<set>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	set<string> st;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		st.insert(s);
	}

	int count = 0;
	for (const auto& i : st) {
		if (i.length() < 6) continue;
		string check = i.substr(i.length() - 6);
		if (check == "Cheese") count++;
	}
	if (count >= 4) cout << "yummy";
	else cout << "sad";
	return 0;
}