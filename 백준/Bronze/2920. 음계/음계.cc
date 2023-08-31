#include<iostream>
using namespace std;

int d[10] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	for (int i = 1; i <= 8; i++) {
		cin >> d[i];
	}

	int asc = 1, des = 1;

	for (int i = 1; i <= 8; i++) {
		if (d[i] != i) asc = 0;
		if (d[i] != (9 - i)) des = 0;
	}

	if (asc == 1) cout << "ascending";
	else if (des == 1) cout << "descending";
	else cout << "mixed";

	return 0;
}