#include<iostream>
using namespace std;

void bs(int n, int key) {
	int start = 1;
	int end = 50;
	while (1) {
		if (start > end) break;
		int mid = (start + end) / 2;
		if (mid == key) {
			cout << key << '\n';
			break;
		}
		else if (mid > key) {
			cout << mid << " ";
			end = mid - 1;
		}
		else {
			cout << mid << " ";
			start = mid + 1;
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		bs(50, n);
	}
	return 0;
}