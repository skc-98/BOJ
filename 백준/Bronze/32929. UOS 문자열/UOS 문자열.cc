#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n;
	cin >> n;

	if (n % 3 == 1) cout << "U";
	else if (n % 3 == 2) cout << "O";
	else cout << "S";
	return 0;
}