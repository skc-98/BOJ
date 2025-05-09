#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n;
    cin >>n;
    
    int year=2024;
    int month=8;
    month+=((n-1)*7);
    year += (month - 1) / 12;
    month = (month - 1) % 12 + 1;
    cout << year << " " << month;
    return 0;
}