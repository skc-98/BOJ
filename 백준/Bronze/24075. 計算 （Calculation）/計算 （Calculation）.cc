#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;
	
	int n = a + b;
	int m = a - b;
	cout << max(n, m) << '\n';
	cout << min(n, m) << '\n';
	return 0;
}