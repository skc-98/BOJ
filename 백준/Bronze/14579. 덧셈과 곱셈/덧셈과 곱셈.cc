#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	long long sum = 1;
	for (int i = n; i <= m; i++) {
		int sum2 = 0;
		for (int j = 1; j <= i; j++) {
			sum2 += j;
		}
		sum *= sum2;
		sum %= 14579;
	}
	cout << sum;
	return 0;
}