#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		int a, b;
		cin >> a >> b;
		int count = 0;
		for (int j = a; j <= b; j++) {
			int num = j;
			while (1) {
				if (num % 10 == 0) count++;
				num /= 10;
				if (num == 0) break;
			}
		}
		cout << count << '\n';
	}

	return 0;
}