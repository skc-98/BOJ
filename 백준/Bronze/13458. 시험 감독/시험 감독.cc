#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int b, c;
	cin >> b >> c;

	long long count = 0;
	for (int i = 0; i < v.size(); i++) {
		count++;
		v[i] -= b;
		if (v[i] <= 0) continue;
		else {
			count += (v[i] / c);
			v[i] = v[i] % c;
			if (v[i] != 0) {
				count++;
				v[i] = 0;
			}
		}
	}
	cout << count;

	return 0;
}