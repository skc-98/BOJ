#include<iostream>
using namespace std;

int gcd(int a, int b) {
	while (b != 0) {
		int temp = b;
		b = a % b;
		a = temp;
	}
	return a;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a1, b1, a2, b2;
	cin >> a1 >> b1;
	cin >> a2 >> b2;

	int head, tail;
	head = (a1 * b2) + (a2 * b1);
	tail = b1 * b2;

	int n = gcd(head, tail);
	head /= n;
	tail /= n;
	cout << head << " " << tail;

	return 0;
}