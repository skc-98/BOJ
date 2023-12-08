#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
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
		v.push_back(a);
	}
	
	vector<long long> answer;
	for (int i = 0; i < v.size(); i++) {
		reverse(v[i].begin(), v[i].end());
		answer.push_back(stoll(v[i]));
	}
	sort(answer.begin(), answer.end());
	
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << '\n';
	}
	return 0;
}