#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int isbn[13] = {9, 7, 8, 0, 9, 2, 1, 4, 1, 8};
    int digit;

    for (int i = 0; i < 3; i++) {
        cin >> digit;
        isbn[10 + i] = digit;
    }

    int sum = 0;

    for (int i = 0; i < 13; i++) {
        if (i % 2 == 0) {
            sum += isbn[i] * 1;
        } else {
            sum += isbn[i] * 3;
        }
    }

    cout << "The 1-3-sum is " << sum << endl;

    return 0;
}