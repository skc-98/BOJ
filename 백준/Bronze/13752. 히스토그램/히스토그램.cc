#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		for (int j = 1; j <= a; j++) {
			cout << "=";
		}
		cout << '\n';
	}

	return 0;
}