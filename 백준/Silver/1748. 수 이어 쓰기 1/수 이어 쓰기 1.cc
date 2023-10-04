#include<iostream>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	int count = 0;
	for (int i = 1; i <= n; i *= 10) count += (n - i + 1);
	cout << count;
	return 0;
}