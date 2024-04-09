#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

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
	sort(v.begin(), v.end());

	int minus = round(n * 0.15);

	int sum = 0, count = 0;
	for (int i = minus; i < v.size() - minus; i++) {
		sum += v[i]; count++;
	}

	double avg = 0;
	if (count != 0) {
		avg = double(sum) / count;
	}
	cout << round(avg);
	return 0;
}