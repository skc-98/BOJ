#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	getline(cin, s);
	
	if (s.size() < 3) {
		cout << "none";
		return 0;
	}

	int hcount = 0, scount = 0;

	for (int i = 0; i <= s.size() - 3; ++i) {
		if (s.substr(i, 3) == ":-)") hcount++;
		else if (s.substr(i, 3) == ":-(") scount++;
	}

	if (hcount == 0 && scount == 0) cout << "none";
	else if (hcount == scount) cout << "unsure";
	else if (hcount > scount) cout << "happy";
	else if (hcount < scount) cout << "sad";
	return 0;
}