#include<iostream>
#include<vector>
using namespace std;

#define num 1000001

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<bool> v(num, true);
	v[0] = false;
	v[1] = false;
	for (int i = 2; i * i < num; i++) {
		if (v[i] == true) {
			for (int j = i * i; j < num; j += i) v[j] = false;
		}
	}

	for (int i = 0; i < n; i++) {
		int num1 = 0, num2 = 1000001;
		int a;
		cin >> a;
		for (int j = 2; j <= a / 2; j++) {
			if (v[j] == true && v[a - j] == true) {
				if (num2 - num1 > (a - j) - j) {
					num2 = a - j;
					num1 = j;
				}
			}
		}
		cout << num1 << " " << num2 << '\n';
	}
	return 0;
}