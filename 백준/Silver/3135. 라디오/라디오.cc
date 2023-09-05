#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a, b, n;
	cin >> a >> b;
	cin >> n;
	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	vector<int> count;
	for (int i = 0; i < v.size(); i++) {
		count.push_back(abs(v[i] - b) + 1);
	}
	count.push_back(abs(a - b));

	int min = 99999;
	for (int i = 0; i < count.size(); i++) if (min > count[i]) min = count[i];
	cout << min;

	return 0;
}