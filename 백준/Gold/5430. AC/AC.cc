#include<iostream>
#include<string>
#include<deque>
#include<sstream>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		string s, ac; int n;
		cin >> s;
		cin >> n;
		cin >> ac;

		// stringstream 이용해서 숫자만 deque에 저장
		deque<int> numbers;
		stringstream ss(ac);
		int num; char discard;
		ss >> discard;
		while (ss >> num) {
			numbers.push_back(num);
			if (ss.peek() == ',') ss.ignore();
		}
		ss >> discard;

		// 명령 수행부분
		int revcount = 0;
		bool rev = 0;
		int error = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s[j] == 'R') {
				revcount++;
				if (rev == 0) rev = 1;
				else rev = 0;
			}
			else if (s[j] == 'D') {
				if (numbers.empty() == true) {
					cout << "error" << '\n';
					error = 1;
					break;
				}
				else {
					if (rev == 0) numbers.pop_front();
					else numbers.pop_back();
				}
			}
		}
		if (revcount % 2 == 1) reverse(numbers.begin(), numbers.end());
		if (error == 1) continue;
		// 출력부분
		cout << '[';
		for (int j = 0; j < numbers.size(); j++) {
			if (j == (numbers.size() - 1)) cout << numbers[j];
			else cout << numbers[j] << ",";
		}
		cout << ']';
		cout << '\n';
	}
	return 0;
}