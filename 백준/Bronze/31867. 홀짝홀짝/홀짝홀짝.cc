#include<iostream>
#include<cstring>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    string s;
    cin >>s;
    
    int odd=0, even=0;
    for(int i=0; i<s.length(); i++){
        int digit=s[i] - '0';
        if(digit%2==1){
            odd++;
        }
        else even++;
    }
    
    if(even>odd) cout << 0;
    else if(odd>even) cout << 1;
    else cout << -1;
    return 0;
}