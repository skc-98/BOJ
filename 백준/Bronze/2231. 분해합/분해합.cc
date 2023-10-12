#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n;
	cin >> n;

	int answer = 0;
	
	for (int i = 1; i <= n; i++) {
		int sum = i;
		int a = i;
		while (1) {
			if (a == 0) break;
			sum += (a % 10);
			a /= 10;
		}
		if (sum == n) {
			answer = i;
			break;
		}
	}

	cout << answer;
	return 0;
}