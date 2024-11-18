#include<iostream>
#include<vector>
#include<algorithm>
#include<iomanip>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<double> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	double sum1 = 0;
	for (int i = m; i < n - m; i++) sum1 += v[i];
	double avg1 = sum1 / (n - 2 * m);
	cout << fixed << setprecision(2) << round(avg1 * 100) / 100 << '\n';

	double sum2 = 0;
	sum2 += m * v[m];
	for (int i = m; i < n - m; i++) sum2 += v[i];
	sum2 += m * v[n - m - 1];
	double avg2 = sum2 / n;
	cout << fixed << setprecision(2) << round(avg2 * 100) / 100;
	return 0;
}