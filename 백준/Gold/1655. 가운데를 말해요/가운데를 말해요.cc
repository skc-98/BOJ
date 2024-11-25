#include<iostream>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

    priority_queue<int> max;
    priority_queue<int, vector<int>, greater<int>> min;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        if (max.empty() || a <= max.top()) max.push(a);
        else min.push(a);

        if (max.size() > min.size() + 1) {
            min.push(max.top());
            max.pop();
        }
        else if (min.size() > max.size()) {
            max.push(min.top());
            min.pop();
        }
        cout << max.top() << '\n';
    }
	return 0;
}