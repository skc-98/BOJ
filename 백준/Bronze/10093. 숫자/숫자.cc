#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n, m;
	cin >> n >> m;
	
	if (n > m) {
		long long temp = m;
		m = n;
		n = temp;
	}

	long long count = m - n - 1;
	if (n == m) cout << 0 << '\n';
	else cout << count << '\n';
	for (long long i = n + 1; i <= m - 1; i++) {
		cout << i << " ";
	}

	return 0;
}