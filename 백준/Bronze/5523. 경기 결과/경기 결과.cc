#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int acount = 0, bcount = 0;
	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		if (a > b) acount++;
		else if (a < b) bcount++;
	}

	cout << acount << " " << bcount;
	return 0;
}