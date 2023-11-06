#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int count = 0;
	for (int i = 1; i <= n - 1; i++) {
		if (i == 1) count += 31;
		else if (i == 2) count += 28;
		else if (i == 3) count += 31;
		else if (i == 4) count += 30;
		else if (i == 5) count += 31;
		else if (i == 6) count += 30;
		else if (i == 7) count += 31;
		else if (i == 8) count += 31;
		else if (i == 9) count += 30;
		else if (i == 10) count += 31;
		else if (i == 11) count += 30;
		else count += 31;
	}
	count += m;

	if (count % 7 == 1) cout << "MON";
	else if (count % 7 == 2) cout << "TUE";
	else if (count % 7 == 3) cout << "WED";
	else if (count % 7 == 4) cout << "THU";
	else if (count % 7 == 5) cout << "FRI";
	else if (count % 7 == 6) cout << "SAT";
	else if (count % 7 == 0) cout << "SUN";

	return 0;
}