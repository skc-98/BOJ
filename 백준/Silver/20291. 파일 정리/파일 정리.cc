#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		a.erase(0, a.find('.') + 1);
		v.push_back(a);
	}
	stable_sort(v.begin(), v.end());

	int count = 0;
	for (int i = 0; i < v.size() - 1; i++) {
		if (v[i] == v[i + 1]) count++;
		else if (v[i] != v[i + 1]) {
			count++;
			cout << v[i] << " " << count << '\n';
			count = 0;
		}
	}
	if (count != 0) {
		count++;
		cout << v[v.size()-1] << " " << count << '\n';
	}
	else if (v[v.size() - 2] != v[v.size() - 1]) {
		cout << v[v.size() - 1] << " " << 1 << '\n';
	}
	return 0;
}