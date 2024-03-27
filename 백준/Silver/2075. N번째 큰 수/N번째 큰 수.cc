#include<iostream>
#include<cstdio>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	scanf("%d", &n);

	int min = 999999;
	priority_queue<int, vector<int>, greater<>> q;
	for (int i = 0; i < n * n; i++) {
		int a;
		scanf("%d", &a);
		q.push(a);
		if(q.size()>n) q.pop();
	}
	printf("%d", q.top());
	return 0;
}