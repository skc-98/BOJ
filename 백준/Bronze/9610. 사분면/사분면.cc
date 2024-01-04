#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
	int axis = 0;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		if (a > 0 && b > 0) q1++;
		else if (a < 0 && b>0) q2++;
		else if (a < 0 && b < 0) q3++;
		else if (a > 0 && b < 0) q4++;
		else axis++;
	}
	cout << "Q1: " << q1 << '\n';
	cout << "Q2: " << q2 << '\n';
	cout << "Q3: " << q3 << '\n';
	cout << "Q4: " << q4 << '\n';
	cout << "AXIS: " << axis;
	return 0;
}