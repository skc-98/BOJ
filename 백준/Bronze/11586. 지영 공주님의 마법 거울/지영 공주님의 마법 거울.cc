#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	vector<string> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	int a;
	cin >> a;
	if (a == 1) {
		for (int i = 0; i < n; i++) {
			cout << v[i] << '\n';
		}
	}
	else if (a == 2) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				cout << v[i][j];
			}
			cout << '\n';
		}
	}
	else {
		for (int i = n - 1; i >= 0; i--) {
			cout << v[i] << '\n';
		}
	}
	return 0;
}