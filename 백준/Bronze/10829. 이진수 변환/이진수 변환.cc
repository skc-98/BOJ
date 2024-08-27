#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n;
	cin >> n;

	vector<int> v;
	while (1) {
		if (n == 0) break;
		v.push_back(n % 2);
		n /= 2;
	}
	reverse(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++) cout << v[i];
	return 0;
}