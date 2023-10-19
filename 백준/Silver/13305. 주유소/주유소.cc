#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> dis;
	for (int i = 1; i <= n - 1; i++) {
		int a;
		cin >> a;
		dis.push_back(a);
	}

	vector<int> money;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		money.push_back(a);
	}

	int answer = 0;
	int state = 0;
	for (int i = 0; i < money.size() - 1; i++) {
		int count = dis[i];
		if (state != 0) {
			state--;
			continue;
		}
		for (int j = i + 1; j < money.size(); j++) {
			if (money[j] <= money[i]) {
				answer += (money[i] * count);
				break;
			}
			else {
				count += dis[j];
				state++;
			}
		}
	}
	cout << answer;
	return 0;
}