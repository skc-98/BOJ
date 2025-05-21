#include <iostream>
#include <sstream>
#include <cstring>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    cin.ignore();
    
    for (int i = 0; i < n; i++) {
        string s;
        getline(cin, s);

        stringstream ss(s);
        int num, sum = 0;
        while (ss >> num) {
            sum += num;
        }

        cout << sum << '\n';
    }
    return 0;
}