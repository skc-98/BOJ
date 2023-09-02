#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string a;
	int count = 0;
	while (1) {
		count = 0;
		getline(cin, a);
		if (a == "#") break;
		for (int i = 0; i < a.length(); i++) {
			if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
				count++;
			}
			if (a[i] == 'A' || a[i] == 'E' || a[i] == 'I' || a[i] == 'O' || a[i] == 'U') {
				count++;
			}
		}
		cout << count << '\n';
	}
	
	return 0;
}