#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	while (1) {
		if (n % 2 == 0) {
			n /= 2;
			continue;
		}
		if (n == 1) {
			cout << 1;
			break;
		}
		else {
			cout << 0;
			break;
		}
	}

	return 0;
}