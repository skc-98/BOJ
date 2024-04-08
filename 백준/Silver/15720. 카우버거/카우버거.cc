#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;
	int low = min(a, b);
	low = min(low, c);

	int total = 0;
	int sale = 0;
	vector<int> buger;
	for (int i = 0; i < a; i++) {
		int a;
		cin >> a;
		total += a;
		buger.push_back(a);
	}
	sort(buger.begin(), buger.end(), cmp);
	int bcount = low;
	for (int i = 0; i < buger.size(); i++) {
		if (bcount > 0) sale += buger[i] * 0.9;
		else sale += buger[i];
		bcount--;
	}

	vector<int> side;
	for (int i = 0; i < b; i++) {
		int a;
		cin >> a;
		total += a;
		side.push_back(a);
	}

	sort(side.begin(), side.end(), cmp);
	int scount = low;
	for (int i = 0; i < side.size(); i++) {
		if (scount > 0) sale += side[i] * 0.9;
		else sale += side[i];
		scount--;
	}

	vector<int> drink;
	for (int i = 0; i < c; i++) {
		int a;
		cin >> a;
		total += a;
		drink.push_back(a);
	}
	sort(drink.begin(), drink.end(), cmp);
	int dcount = low;
	for (int i = 0; i < drink.size(); i++) {
		if (dcount > 0) sale += drink[i] * 0.9;
		else sale += drink[i];
		dcount--;
	}

	cout << total << '\n';
	cout << sale;
	return 0;
}