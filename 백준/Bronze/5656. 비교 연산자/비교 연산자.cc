#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a, b;
    string oper;
    int caseNum=1;

    while (cin >> a >> oper >> b) {
        if(oper=="E"){
            break;
        }

        bool result = false;
        if(oper==">"){
            result=(a>b);
        }
        else if(oper==">="){
            result=(a>=b);
        }
        else if(oper=="<"){
            result=(a<b);
        }
        else if(oper=="<="){
            result=(a<=b);
        }
        else if(oper=="=="){
            result=(a==b);
        }
        else if(oper=="!="){
            result=(a!=b);
        }
        
        if(result){
            cout << "Case " << caseNum++ << ": true" << '\n';
        }
        else{
            cout << "Case " << caseNum++ << ": false" << '\n';
        }
    }
    return 0;
}