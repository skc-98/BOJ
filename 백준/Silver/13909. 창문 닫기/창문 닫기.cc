#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int count = 0;
	for (int i = 1; i * i <= n; i++) {
		count++;
	}
	cout << count;

	return 0;
}