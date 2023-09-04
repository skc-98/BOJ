#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string s;
	cin >> s;

	int count = 0;
	double sum = 0;
	double result;

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '+') continue;
		if (s[i + 1] == '+') {
			if (s[i] == 'A') {
				sum += 4.5;
				count++;
			}
			if (s[i] == 'B') {
				sum += 3.5;
				count++;
			}
			if (s[i] == 'C') {
				sum += 2.5;
				count++;
			}
			if (s[i] == 'D') {
				sum += 1.5;
				count++;
			}
		}
		else {
			if (s[i] == 'A') {
				sum += 4.0;
				count++;
			}
			if (s[i] == 'B') {
				sum += 3.0;
				count++;
			}
			if (s[i] == 'C') {
				sum += 2.0;
				count++;
			}
			if (s[i] == 'D') {
				sum += 1.0;
				count++;
			}
			if (s[i] == 'F') count++;
		}
	}

	cout << sum / count;

	return 0;
}