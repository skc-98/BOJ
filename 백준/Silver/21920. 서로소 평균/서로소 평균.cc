#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int prime(int n, int m) {
	while (1) {
		if (m == 0) break;
		int temp = m;
		m = n % m;
		n = temp;
	}
	return n;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	int x;
	cin >> x;

	vector<int> v2;
	for (int i = 0; i < n; i++) {
		if (prime(v[i], x) == 1) {
			v2.push_back(v[i]);
		}
	}

	double sum = 0;
	for (int i = 0; i < v2.size(); i++) {
		sum += v2[i];
	}
	cout << sum / v2.size();

	return 0;
}