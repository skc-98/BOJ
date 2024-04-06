#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(const pair<int, string>& a, const pair<int, string>& b) {
	return a.second < b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<pair<int, string>> v;
	for (int i = n; i <= m; i++) {
		string s = "";
		int num = i;
		vector<string> v2;
		while (1) {
			if (num == 0) break;
			int a = num % 10;
			num /= 10;
			if (a == 0) v2.push_back("zero");
			else if (a == 1) v2.push_back("one");
			else if (a == 2) v2.push_back("two");
			else if (a == 3) v2.push_back("three");
			else if (a == 4) v2.push_back("four");
			else if (a == 5) v2.push_back("five");
			else if (a == 6) v2.push_back("six");
			else if (a == 7) v2.push_back("seven");
			else if (a == 8) v2.push_back("eight");
			else if (a == 9) v2.push_back("nine");
		}
		reverse(v2.begin(), v2.end());
		for (int j = 0; j < v2.size(); j++) {
			s += v2[j];
			s += " ";
		}
		v.push_back(make_pair(i, s));
	}
	sort(v.begin(), v.end(), cmp);

	int  count = 0;
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " ";
		count++;
		if (count == 10) {
			count = 0;
			cout << '\n';
		}
	}
	return 0;
}