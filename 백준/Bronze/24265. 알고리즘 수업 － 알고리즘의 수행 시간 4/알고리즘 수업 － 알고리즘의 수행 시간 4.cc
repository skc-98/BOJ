#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n;
	long long count = 0;
	cin >> n;
	for (int i = 1; i <= n - 1; i++) {
		for (int j = i + 1; j <= n; j++) {
			count++;
		}
	}
	cout << count << '\n';
	cout << 2;

	return 0;
}