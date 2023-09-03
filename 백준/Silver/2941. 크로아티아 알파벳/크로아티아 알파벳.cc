#include<iostream>
#include<string>
using namespace std;

int main()
{
	int count = 0;
	string a;
	cin >> a;
	
	for (int i = 0; i < a.length(); i++) {
		if (a[i] == 'c') {
			if (a[i + 1] == '=' || a[i + 1] == '-') {
				count++;
				i++;
				continue;
			}
		}
		else if (a[i] == 'd') {
			if (a[i + 1] == 'z' && a[i + 2] == '=') {
				count++;
				i += 2;
				continue;
			}
			if (a[i + 1] == '-') {
				count++;
				i++;
				continue;
			}
		}
		else if (a[i] == 'l' && a[i + 1] == 'j') {
			count++;
			i++;
			continue;
		}
		else if (a[i] == 'n' && a[i + 1] == 'j') {
			count++;
			i++;
			continue;
		}
		else if (a[i] == 's' && a[i + 1] == '=') {
			count++;
			i++;
			continue;
		}
		else if (a[i] == 'z' && a[i + 1] == '=') {
			count++;
			i++;
			continue;
		}
		count++;
	}

	cout << count;
	return 0;
}