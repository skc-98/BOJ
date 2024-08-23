#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int ys = 0;
	int ms = 0;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		ys += (a / 30 + 1) * 10;
		ms += (a / 60 + 1) * 15;
	}

	if (ys < ms) {
		cout << "Y " << ys;
	}
	else if (ys > ms) {
		cout << "M " << ms;
	}
	else {
		cout << "Y M " << ys;
	}

	return 0;
}