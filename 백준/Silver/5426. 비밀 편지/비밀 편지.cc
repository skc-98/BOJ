#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		char d[101][101] = { 0, };
		string a;
		cin >> a;
		int area = sqrt(a.length());

		int count = 0;
		int index = 0;
		for (int j = 0; j < a.length(); j++) {
			d[index][count] = a[j];
			count++;
			if (count - area == 0) {
				count -= area;
				index++;
			}
		}
		for (int j = area-1; j >= 0; j--) {
			for (int k = 0; k < area; k++) {
				cout << d[k][j];
			}
		}
		cout << '\n';
	}
	return 0;
}