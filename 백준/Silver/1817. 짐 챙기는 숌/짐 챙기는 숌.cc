#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int count = 0;
	for (int i = 0; i < v.size(); i++) {
		int pointer = i;
		int sum = 0;
		while (pointer<v.size()) {
			sum += v[pointer];
			if (sum > m) {
				pointer--;
				break;
			}
			pointer++;
		}
		i = pointer;
		count++;
	}
	cout << count;
	return 0;
}