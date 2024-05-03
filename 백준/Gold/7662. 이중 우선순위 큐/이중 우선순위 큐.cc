#include<iostream>
#include<set>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int n;
		cin >> n;
		multiset<int> ms;
		for (int j = 0; j < n; j++) {
			char order;
			cin >> order;
			if (order == 'I') {
				int a;
				cin >> a;
				ms.insert(a);
			}
			else if (order == 'D') {
				int a;
				cin >> a;
				if (ms.empty()) continue;
				if (a == 1) ms.erase(prev(ms.end()));
				else if (a == -1) ms.erase(ms.begin());
			}
		}
		if (ms.empty()) cout << "EMPTY" << '\n';
		else {
			cout << *prev(ms.end()) << " " << *ms.begin() << '\n';
		}
	}

	return 0;
}