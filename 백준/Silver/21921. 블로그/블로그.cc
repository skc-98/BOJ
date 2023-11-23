#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v(n + 1);
	int last = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		last += a;
		v[i] = last;
	}
	
	int high = 0;
	int count = 0;
	for (int i = 1; i <= n - m + 1; i++) {
		if (high < (v[i + m - 1] - v[i - 1])) {
			count = 1;
			high = v[i + m - 1] - v[i - 1];
		}
		else if (high == (v[i + m - 1] - v[i - 1])) count++;
	}
	if (high == 0) {
		cout << "SAD";
		return 0;
	}
	cout << high << '\n';
	cout << count;
	return 0;
}