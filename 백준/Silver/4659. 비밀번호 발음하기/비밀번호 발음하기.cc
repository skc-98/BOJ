#include<iostream>
#include<string>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    while (1) {
        string s;
        cin >> s;
        if (s == "end") break;

        bool rule1 = 0, rule2 = 1, rule3 = 1;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                rule1 = 1;
                cnt1++;
                cnt2 = 0;
                if (cnt1 >= 3) rule2 = 0;
            }
            else {
                cnt2++;
                cnt1 = 0;
                if (cnt2 >= 3) rule2 = 0;
            }

            if (i > 0 && s[i] == s[i - 1] && s[i] != 'e' && s[i] != 'o') {
                rule3 = 0;
            }
        }

        if (rule1 && rule2 && rule3) cout << "<" << s << "> is acceptable." << '\n';
        else cout << "<" << s << "> is not acceptable." << '\n';
    }
    return 0;
}
