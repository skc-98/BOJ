#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<long long> dis;
	for (int i = 1; i <= n - 1; i++) {
		int a;
		cin >> a;
		dis.push_back(a);
	}

	vector<long long> money;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		money.push_back(a);
	}

	long long answer = 0;
	
	long long max = 999999999999;
	for (int i = 0; i < dis.size(); i++) {
		if (money[i] < max) max = money[i];
		answer += max * dis[i];
	}
	cout << answer;
	return 0;
}