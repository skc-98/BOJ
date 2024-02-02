#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < 5; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	int count = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i] == n) count++;
	}
	cout << count;
	return 0;
}