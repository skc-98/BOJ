#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a,b;
    cin >>a>>b;
    
    double sevenPrice=(1000.0/b)*a;
    
    int n;
    cin >>n;
    
    for(int i=0; i<n; i++){
        int x,y;
        cin >>x>>y;
        double price=(1000.0/y)*x;
        if(price<sevenPrice) sevenPrice=price;
    }
    
    cout << fixed;
    cout.precision(2);
    cout << sevenPrice;
    return 0;
}