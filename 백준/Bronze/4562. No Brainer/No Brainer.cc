#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		if (a >= b) cout << "MMM BRAINS" << '\n';
		else cout << "NO BRAINS" << '\n';
	}

	return 0;
}