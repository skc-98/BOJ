#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int counta = 0;
	int countb = 0;

	for (int i = 1; i <= 3; i++) {
		int a; 
		cin >> a;
		if (a == 1) counta++;
		else countb++;
	}
	if (counta > countb) cout << 1;
	else cout << 2;
	return 0;
}