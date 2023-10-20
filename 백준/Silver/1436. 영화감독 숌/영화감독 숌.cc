#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int num = 666;
	int count = 0;

	while (count<n){
		string s = to_string(num);
		for (int i = 0; i < s.length() - 2; i++) {
			if (s[i] == '6' && s[i + 1] == '6' && s[i + 2] == '6') {
				count++;
				if (count == n) {
					cout << num;
					return 0;
				}
				break;
			}
		}
		num++;
	}
	return 0;
}