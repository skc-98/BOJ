n=int(input());
s=input();

a = s.count("security");
b = s.count("bigdata");

if(a>b):
    print("security!");
elif(b>a):
    print("bigdata?");
else:
    print("bigdata? security!");
