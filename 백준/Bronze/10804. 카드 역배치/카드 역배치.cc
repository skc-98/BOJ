#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	vector<int> v;
	for (int i = 1; i <= 20; i++) {
		v.push_back(i);
	}

	for (int i = 1; i <= 10; i++) {
		int n, m;
		cin >> n >> m;
		reverse(v.begin() + n - 1 , v.begin() + m);
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}

	return 0;
}