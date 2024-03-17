#include<iostream>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a;
	int total = 0;
	map<string, double> mp;
	while (cin>>a) {
		total++;
		if (a != "Re" && a != "Pt" && a != "Cc" && a != "Ea" && a != "Tb" && a != "Cm" && a != "Ex") continue;
		mp[a]++;
	}

	cout << fixed;
	cout.precision(2);

	cout << "Re" << " " << (int)mp["Re"] << " " << (mp["Re"] / total) << '\n';
	cout << "Pt" << " " << (int)mp["Pt"] << " " << (mp["Pt"] / total) << '\n';
	cout << "Cc" << " " << (int)mp["Cc"] << " " << (mp["Cc"] / total) << '\n';
	cout << "Ea" << " " << (int)mp["Ea"] << " " << (mp["Ea"] / total) << '\n';
	cout << "Tb" << " " << (int)mp["Tb"] << " " << (mp["Tb"] / total) << '\n';
	cout << "Cm" << " " << (int)mp["Cm"] << " " << (mp["Cm"] / total) << '\n';
	cout << "Ex" << " " << (int)mp["Ex"] << " " << (mp["Ex"] / total) << '\n';
	cout << "Total" << " " << (int)total << " " << (double)(total / total) << '\n';
	return 0;
}