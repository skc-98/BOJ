#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	while (1) {
		bool prime = true;
        if (n < 2) {
            prime = false;
        }
        else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        if (!prime) {
            cout << n;
            return 0;
        }
		n++;
	}
	return 0;
}