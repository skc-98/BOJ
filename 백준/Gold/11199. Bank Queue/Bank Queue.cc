#include<iostream>
#include<queue>
#include<vector>
#include<utility>
#include<functional>
using namespace std;

// 우선순위 큐를 정렬하는 비교연산 cmp
// 현금이 높은 순서대로 우선순위 지정
// 현금이 같다면 대기시간이 긴 사람이 높은 우선순위 지정
struct cmp {
	bool operator()(pair<int, int>& a, pair<int, int>& b) {
		if (a.first == b.first) {
			return a.second < b.second;
		}
		else {
			return a.first < b.first;
		}
	}
};

int main()
{
	int i;
	int n, t; // 사람의 수 n, 은행이 문닫을 때까지의 시간 t

	cin >> n; // 사람의 수 입력 
	cin >> t; // 문닫을 때까지 시간 입력

	int a, b; // 현금의 양 a, 최대 대기 시간 b
	priority_queue<pair<int,int>, vector<pair<int,int>>, cmp> q; // 두 값을 저장할 우선순위 큐

	// 사람의 수만큼 현금의 양과 최대 대기 시간을 입력한다.
	for (i = 1; i <= n; i++) {
		cin >> a >> b; // 현금의 양과 최대 대기 시간 입력
		q.push(make_pair(a, b)); // 우선순위 큐에 값을 저장한다.
	}
	
	int j;
	int time[48] = { 0, }; // 현금을 받을 수 있는지 체크하는 배열, 은행을 닫을 때까지 최대 시간은 47

	// n명의 사람이 있으니까 n번만큼 반복한다.
	for (i = 0; i < n; i++) {

		// 고객이 대기 할수있는 시간까지 빈 자리가 존재하면 그 자리에 고객의 현금량 추가
		for (j = q.top().second; j >= 0; j--) {
			if (time[j] == 0) {
				time[j] = q.top().first;
				break;
			}
		}

		q.pop(); // 확인한 고객은 큐에서 제외
	}

	int sum = 0; // 총 현금량

	// 최대 t분에 은행의 문을 닫기 때문에 t까지 반복하면서 구해둔 현금의 합 구하기
	for (i = 0; i < t; i++) {
		sum += time[i];
	}
	cout << sum; // 결과 출력

	return 0;
}