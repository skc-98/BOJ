#include<iostream>
#include<vector>
#include<algorithm>
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
	int firstcheck = 0;
	int now = v[0];
	int count = 0;
	if (v[0] == 0) {
		count++;
		firstcheck = 1;
	}

	for (int i = 1; i < v.size(); i++) {
		if (firstcheck == 0) {
			if (v[i] == 0) {
				now = 0;
				count++;
				firstcheck = 1;
			}
			else continue;
		}
		if (now == 0) {
			if (v[i] == 1) {
				now = 1;
				count++;
			}
		}
		else if (now == 1) {
			if (v[i] == 2) {
				now = 2;
				count++;
			}
		}
		else {
			if (v[i] == 0) {
				now = 0;
				count++;
			}
		}
	}
	cout << count;
	return 0;
}