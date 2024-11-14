#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v;
	for (int i = 0; i < 5; i++) {
		string s;
		cin >> s;
		if (s.find("FBI") != string::npos) v.push_back(i + 1);
	}
	if (v.empty()) cout << "HE GOT AWAY!";
	else {
		for (int i = 0; i < v.size(); i++) {
			cout << v[i] << " ";
		}
	}
	return 0;
}