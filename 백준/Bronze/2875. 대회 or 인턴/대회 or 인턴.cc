#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;

	int count = 0;
	int limit = n + m - k;
	while (1) {
		if (n < 2 || m < 1 || 3 * count >= limit - 2) break;
		else {
			n -= 2;
			m--;
			count++;
		}
	}
	cout << count;
	return 0;
}