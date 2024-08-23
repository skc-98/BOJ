#include<iostream>
using namespace std;

int d[7][3];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, k;
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		bool gender;
		int grade;
		cin >> gender >> grade;
		d[grade][gender]++;
	}

	int count = 0;
	for (int i = 1; i < 7; i++) {
		for (int j = 0; j < 2; j++) {
			count += (d[i][j] / k);
			if (d[i][j] % k != 0) {
				count++;
			}
		}
	}
	cout << count;
	return 0;
}