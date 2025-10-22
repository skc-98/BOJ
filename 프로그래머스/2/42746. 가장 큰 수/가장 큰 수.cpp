#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool comparator(int a, int b){
    string s1=to_string(a);
    string s2=to_string(b);
    return stoi(s1+s2)>stoi(s2+s1);
}

string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), comparator);
    
    for(int i=0; i<numbers.size(); i++){
        answer+=to_string(numbers[i]);
    }
    
    if(answer[0] == '0') return "0";
    return answer;
}