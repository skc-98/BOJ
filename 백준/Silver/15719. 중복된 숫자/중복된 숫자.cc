#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	long long sum = 0;
	long long sum2 = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sum2 += a;
		sum += i;
	}
	sum -= sum2;
	cout << n - sum;

	return 0;
}