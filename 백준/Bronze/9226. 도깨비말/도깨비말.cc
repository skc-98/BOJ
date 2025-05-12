#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    while(true){
        string ss="";
        string s;
        cin >>s;
        if(s=="#") break;
        
        bool check=false;
        
        for(int i=0; i<s.length(); i++){
            if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u'){
                string ans=s.substr(i);
                ans+=ss;
                ans+="ay";
                cout << ans << '\n';
                check=true;
                break;
            }
            ss+=s[i];
        }
        if(!check){
            cout << s+"ay" << '\n';
        }
    }
    return 0;
}