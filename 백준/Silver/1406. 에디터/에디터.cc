#include<iostream>
#include<string>
#include<list>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	int n;
	cin >> n;

	list<char> li;
	for (int i = 0; i < s.length(); i++) {
		li.push_back(s[i]);
	}

	auto pointer = li.end();
	for (int i = 0; i < n; i++) {
		char a;
		cin >> a;
		if (a == 'L') {
			if (pointer != li.begin()) {
				pointer--;
			}
		}
		else if (a == 'D') {
			if (pointer != li.end()) {
				pointer++;
			}
		}
		else if (a == 'B') {
			if (pointer != li.begin()) {
				auto temp = pointer;
				temp--;
				li.erase(temp);
			}
		}
		else if (a == 'P') {
			char b;
			cin >> b;
			li.insert(pointer, b);
		}
	}
	for (const auto &i : li) {
		cout << i;
	}
	return 0;
}