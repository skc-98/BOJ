#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int start = 1, end = 10;
	
	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		string s;
		cin.ignore();
		getline(cin, s);

		if (s == "too high") end = min(end, n - 1);
		else if (s == "too low") start = max(start, n + 1);
		else if (s == "right on") {
			if (n<start || n>end) {
				cout << "Stan is dishonest" << '\n';
			}
			else {
				cout << "Stan may be honest" << '\n';
			}
			start = 1; end = 10;
		}
	}
	return 0;
}