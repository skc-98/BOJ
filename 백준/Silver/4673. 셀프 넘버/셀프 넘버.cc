#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<bool> v(10001, 1);
	for (int i = 1; i <= 10000; i++) {
		int sum = i;
		int n = i;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		if (sum <= 10000) v[sum] = 0;
	}
	for (int i = 1; i <= 10000; i++) {
		if (v[i] == 1) cout << i << '\n';
	}

	return 0;
}