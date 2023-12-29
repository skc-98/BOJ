#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a;
	int n;
	cin >> a;
	cin >> n;

	int count = 0;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		s += s;
		if (s.find(a) != string::npos) {
			count++;
		}
	}
	
	cout << count;
	return 0;
}