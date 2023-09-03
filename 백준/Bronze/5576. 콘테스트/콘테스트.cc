#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	vector<int> v;
	for (int i = 1; i <= 10; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	vector<int> v2;
	for (int i = 1; i <= 10; i++) {
		int a;
		cin >> a;
		v2.push_back(a);
	}
	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end());

	cout << v[7] + v[8] + v[9] << " ";
	cout << v2[7] + v2[8] + v2[9];

	return 0;
}