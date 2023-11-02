#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int p, n;
	cin >> p >> n;
	
	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	int count = 0;
	for (int i = 0; i <n; i++) {
		if (p < 200) {
			p += v[i];
			count++;
		}
		else break;
	}

	cout << count;
	return 0;
}