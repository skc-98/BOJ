#include<iostream>
#include<string>
#include<vector>
using namespace std;

char d[6][16] = { '\0',};
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	for (int i = 0; i < 5; i++) {
		string s;
		getline(cin, s);
		for (int j = 0; j < s.length(); j++) {
			d[i][j] = s[j];
		}
	}

	vector<char> v;
	for (int i = 0; i < 16; i++) {
		for (int j = 0; j < 6; j++) {
			if (d[j][i] != '\0') {
				v.push_back(d[j][i]);
			}
		}
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i];
	}

	return 0;
}