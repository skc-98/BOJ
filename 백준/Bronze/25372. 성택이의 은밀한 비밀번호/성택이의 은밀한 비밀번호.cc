#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		if (a.length() >= 6 && a.length() <= 9) cout << "yes" << '\n';
		else cout << "no" << '\n';
	}

	return 0;
}