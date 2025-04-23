#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    string s;
    cin >> s;
    
    int start=0, end=s.length()-1;
    
    while(start<=end){
        if(s[start]==s[end]){
            start++;
            end--;
        }
        else{
            cout << "false";
            return 0;
        }
    }
    
    cout << "true";
    return 0;
}