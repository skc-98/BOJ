#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const vector<int>& v1, const vector<int>& v2) {
	return v1[2] > v2[2];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<vector<int>> v;
	for (int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		v.push_back({ a,b,c });
	}
	sort(v.begin(), v.end(), cmp);

	int i = 0;
	int cnt = 0;
	vector<int> country(1000);
	while (1) {
		if (cnt == 3) break;
		if (country[v[i][0]] < 2) {
			cnt++;
			country[v[i][0]]++;
			cout << v[i][0] << " " << v[i][1] << '\n';
		}
		i++;
	}
	return 0;
}