#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		string a, b;
		string ca, cb;
		cin >> a >> b;
		ca = a; cb = b;
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());
		if (a == b) {
			cout << ca << " & " << cb << " are anagrams." << '\n';
		}
		else {
			cout << ca << " & " << cb << " are NOT anagrams." << '\n';
		}
	}

	return 0;
}