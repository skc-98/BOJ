#include<iostream>
#include<math.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a,p1;
    int r,p2;
    cin >>a>>p1;
    cin >>r>>p2;
    
    double pizza1=(double)a/p1;
    double pizza2=(M_PI*r*r)/p2;
    
    if(pizza1<pizza2){
        cout << "Whole pizza";
    }
    else{
        cout << "Slice of pizza";
    }
    return 0;
}