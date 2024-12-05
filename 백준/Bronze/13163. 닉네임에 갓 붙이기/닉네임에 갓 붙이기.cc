#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();

	vector<string> name;
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		name.push_back(s);
	}

	for (int i = 0; i < name.size(); i++) {
		string ss = "god";
		bool check = 0;
		for (int j = 0; j < name[i].length(); j++) {
			if (name[i][j] == ' ' && check == 0) check = 1;
			if (check) {
				if (name[i][j] != ' ') {
					ss += name[i][j];
				}
			}
		}
		cout << ss << '\n';
	}

	return 0;
}