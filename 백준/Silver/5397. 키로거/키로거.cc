#include<iostream>
#include<deque>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	while (n--) {
		string s;
		cin >> s;
		deque<char> left;
		deque<char> right;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '<') {
				if (!left.empty()) {
					right.push_front(left.back());
					left.pop_back();
				}
			}
			else if (s[i] == '>') {
				if (!right.empty()) {
					left.push_back(right.front());
					right.pop_front();
				}
			}
			else if (s[i] == '-') {
				if (!left.empty()) left.pop_back();
			}
			else left.push_back(s[i]);
		}
		for (int i = 0; i < left.size(); i++) cout << left[i];
		for (int i = 0; i < right.size(); i++) cout << right[i];
		cout << '\n';
	}
	return 0;
}