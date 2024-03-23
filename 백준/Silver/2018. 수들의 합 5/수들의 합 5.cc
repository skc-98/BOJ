#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int count = 0;
	for (int i = 1; i <= n; i++) {
		int sum = 0;
		for (int j = i; j <= n; j++) {
			sum += j;
			if (sum == n) {
				count++;
				break;
			}
			else if (sum > n) break;
		}
	}
	cout << count;
	return 0;
}