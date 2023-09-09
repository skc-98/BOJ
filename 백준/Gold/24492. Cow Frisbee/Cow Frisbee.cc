#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int main() {
	long long ans = 0; // 답을 저장할 변수 ans
	int n; // 소의 수 n

	cin >> n; // n값 입력

	stack<pair<long long, long long>> s; // 입력값을 저장할 스택 s

	for (int i = 1; i <= n; i++) {
		long long a;
		cin >> a; // 각 소의 키 입력
		
		// 스택이 비어있으면 현재 소의 키와 번호를 스택에 추가
		if (s.empty() == true) s.push(make_pair(a, i));

		// 스택이 비어있지 않을 경우에
		else {
			// 현재 소의 키가 스택의 top에 위치한 소의 키보다 크거나 같으면
			if (a >= s.top().first) {
				// 스택이 비어있지 않고 top 소가 현재 소보다 작으면 top 소를 pop하면서 거리를 추가한다
				while (s.empty() == false && a >= s.top().first) {
					ans += (i - s.top().second + 1);
					s.pop();
				}

				// 이후에도 스택이 비어있지 않으면 top에 위치한 소와의 거리를 더한다
				if (s.empty() == false) ans += (i - s.top().second + 1);

				// 현재 소를 push
				s.push(make_pair(a, i));
			}

			// 현재 소의 크기가 top 소보다 키가 작으면
			else {
				// 바로 거리를 더하고 스택에 현재 소의 정보를 push
				ans += (i - s.top().second + 1);
				s.push(make_pair(a, i));
			}
		}
	}
	// 최종적으로 값을 출력
	cout << ans;

	return 0;
}