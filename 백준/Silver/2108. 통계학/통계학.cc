#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<cmath>
using namespace std;

double avg(const vector<int>& v, int n) {
	double sum = 0;
	for (int i = 0; i < v.size(); i++) {
		sum += v[i];
	}
	return (int)round((double)sum / n);
}

int mid(const vector<int>& v, int n) {
	return v[n / 2];
}

int mode(const vector<int>& v) {
	map<int, int> counts;
	for (int i = 0; i < v.size(); i++) {
		counts[v[i]]++;
	}

	int maxcount = 0;
	vector<int> modes;
	for (const auto& pair : counts) {
		if (pair.second > maxcount) {
			maxcount = pair.second;
			modes.clear();
			modes.push_back(pair.first);
		}
		else if (pair.second == maxcount) {
			modes.push_back(pair.first);
		}
	}

	if (modes.size() == 1) {
		return modes[0];
	}

	sort(modes.begin(), modes.end());
	int secondmode = modes[1];
	return secondmode;
}

int range(const vector<int>& v) {
	int maxvalue = v[0];
	int minvalue = v[0];
	for (int i = 1; i < v.size(); i++) {
		if (maxvalue < v[i]) maxvalue = v[i];
		if (minvalue > v[i]) minvalue = v[i];
	}
	return maxvalue - minvalue;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	double a1;
	a1 = avg(v, n);
	cout << a1 << '\n';

	int a2;
	a2 = mid(v, n);
	cout << a2 << '\n';

	int a3;
	a3 = mode(v);
	cout << a3 << '\n';

	int a4;
	a4 = range(v);
	cout << a4 << '\n';
	return 0;
}