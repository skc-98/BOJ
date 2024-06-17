#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int a, b;
		cin >> a >> b;
		int ca = 0, cb = 0;
		while (1) {
			if (a <= b) break;
			a -= 2;
			b--;
			cb++;
		}
		if (a != 0) ca+=a;
		cout << ca << " " << cb << '\n';
	}

	return 0;
}