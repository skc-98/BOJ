#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a,b,c;
    while(1){
        cin >>a>>b>>c;
        if(a==0 && b==0 && c==0){
            break;
        }
        
        // 등차수열일 때
        if(b-a==c-b){
            cout << "AP" << " " << c+(c-b) << '\n';
        }
        // 등비수열일 때
        else if(b/a==c/b){
            cout << "GP" << " " << c*(c/b) << '\n';
        }
    }
    return 0;
}