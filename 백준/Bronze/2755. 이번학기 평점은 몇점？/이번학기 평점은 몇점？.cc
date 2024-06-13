#include<iostream>
#include<string>
#include<unordered_map>
#include<stdio.h>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	unordered_map<string, double> grade_map = {
		{"A+", 4.3}, {"A0", 4.0}, {"A-", 3.7},
		{"B+", 3.3}, {"B0", 3.0}, {"B-", 2.7},
		{"C+", 2.3}, {"C0", 2.0}, {"C-", 1.7},
		{"D+", 1.3}, {"D0", 1.0}, {"D-", 0.7},
		{"F", 0.0}
	};

	double sum = 0;
	int total = 0;
	for (int i = 0; i < n; i++) {
		string subject, grade;
		int point;
		cin >> subject >> point >> grade;

		sum += point * grade_map[grade];
		total += point;
	}
	printf("%.2f", round(sum / total * 100) / 100);
	return 0;
}