#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, l;
	cin >> n >> l;
	
	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	sort(v.begin(), v.end());

	int index = 0;
	while (1) {
		if (index > v.size()-1) break;
		if (v[index] > l) break;
		else {
			l++;
			index++;
		}
	}

	cout << l;

	return 0;
}