#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	int choco = n;

	while (1) {
		if ((n & (n - 1)) == 0) break;
		n++;
	}

	int half = n;
	int count = 0;
	while (1) {
		if (choco == half) break;
		if (choco - half < 0) {
			half /= 2;
			count++;
			continue;
		}
		if (choco - half == 0) {
			count++;
			break;
		}
		else {
			choco = choco - half;
			count++;
		}
		half /= 2;
	}

	cout << n << " " << count;
	return 0;
}