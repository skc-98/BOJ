#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;

	for (int i = 1; i <= a; i++) {
		for (int j = 1; j <= b; j++) {
			cout << "*";
		}
		cout << endl;
	}
	return 0;
}