#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();

	bool check = true;
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		if (s != "Never gonna give you up" && s != "Never gonna let you down" && s != "Never gonna run around and desert you" && s != "Never gonna make you cry" && s != "Never gonna say goodbye" && s != "Never gonna tell a lie and hurt you" && s != "Never gonna stop") check = false;
	}
	if (check) cout << "No";
	else cout << "Yes";
	return 0;
}