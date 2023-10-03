#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

vector<string> answer;
void bs(const vector<string>& v, string key) {
	int start = 0;
	int end = v.size() - 1;
	while (1) {
		int mid = (start + end) / 2;
		if (v[mid] == key) {
			answer.push_back(key);
			break;
		}
		if (start > end) break;
		if (v[mid] < key) start = mid + 1;
		else end = mid - 1;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<string> v;
	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	for (int i = 1; i <= m; i++) {
		string a;
		cin >> a;
		bs(v, a);
	}
	
	sort(answer.begin(), answer.end());
	cout << answer.size() << '\n';
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << '\n';
	}
	return 0;
}