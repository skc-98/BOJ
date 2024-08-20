#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		if (s == "anj") {
			cout << "뭐야;";
			return 0;
		}
	}
	cout << "뭐야?";
	return 0;
}