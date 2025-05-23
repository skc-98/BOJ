#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    for(int i=0; i<n; i++){
        int a;
        cin >>a;
        
        cout << "Pairs for" << " " << a << ": ";
        for(int j=1; j<=a; j++){
            if(j>a-j) break;
            if(j==a-j) break;
            cout << j << " " << a-j;
            bool check=false;
            if(j+1>a-j-1) check=true;
            if(j+1==a-j-1) check=true;
            if(!check) cout << ", ";
        }
        cout << '\n';
    }
    return 0;
}