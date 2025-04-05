#include<iostream>
#include<string>
using namespace std;

char d[200];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    while(1){
        string s;
        getline(cin,s);
        if(s=="#") break;
        
        for (int i = 0; i < 200; i++) d[i] = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s[i]>='a' && s[i]<='z') d[s[i]]++;
            if(s[i]>='A' && s[i]<='Z') d[tolower(s[i])]++;
        }
        
        int count=0;
        for(char i='a'; i<='z'; i++){
            if(d[i]!=0) count++;
        }
        cout << count <<'\n';
    }
    return 0;
}