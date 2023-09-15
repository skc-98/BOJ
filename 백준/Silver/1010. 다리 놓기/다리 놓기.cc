#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		int a, b;
		cin >> a >> b;

		int n = 1;
		long long answer = 1;
		for (int j = b; j > b-a; j--) {
			answer *= j;
			answer /= n;
			n++;
		}
		cout << answer << '\n';
	}
	return 0;
}