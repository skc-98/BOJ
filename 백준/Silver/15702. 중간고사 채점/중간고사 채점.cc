#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> score;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		score.push_back(a);
	}

	int max = -1;
	int maxnum = 1000000;
	for (int i = 0; i < m; i++) {
		int num;
		cin >> num;
		int sum = 0;
		for (int j = 0; j < n; j++) {
			char a;
			cin >> a;
			if (a == 'O') {
				sum += score[j];
			}
		}
		if (sum > max) {
			max = sum;
			maxnum = num;
		}
		else if (sum == max) {
			if (maxnum > num) maxnum = num;
		}
	}
	cout << maxnum << " " << max;
	return 0;
}