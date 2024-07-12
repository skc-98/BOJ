#include<iostream>
using namespace std;

struct point {
	int x, y;
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	point a, b, c;
	cin >> a.x >> a.y;
	cin >> b.x >> b.y;
	cin >> c.x >> c.y;

	int ccw;
	ccw = (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x);
	if (ccw > 0) cout << 1;
	else if (ccw < 0) cout << -1;
	else cout << 0;
	return 0;
}