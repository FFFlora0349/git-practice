#include <math.h>
#include <stdio.h>

int main(int argc, char* argv[]){
 //3.2.1 escape
 printf("\x57\150\x61\164\x20\144\x6f\40\x77\145\x20\144\x6f\x20\141\x66\164\x65\162\x20\163\x74\141\x72\142\x75\143\x6b\163\x3f\40\x57\145\x20\147\x6f\40\x74\157\40\x73\145\x70\150\x6f\162\x61\40\x61\156\x64\40\x73\151\x6d\157\x6e\163\x20\146\x6f\162\x20\163\x68\157\x70\160\x69\156\x67\56\n"); // \nnn is for oct, \xnnn is for hex.

 //3.2.5 char
 signed char c1 = 119; // char = nnn with %c in printf is for dec.
 signed char c2 = 113;
 unsigned char c3 = 65;
 char c4 = 74;
 printf("c1 %c, c2 %c, c3 %c, c4 %c\n", c1,c2,c3,c4); 
 printf("c1 %d, c2 %d, c3 %d, c4 %d\n", c1,c2,c3,c4);

 //3.2.7 calculation
 int a = -5/3; // truncated, -1.6667 -> -1
 printf("%d\n",a); 
 int i=3,j=4,k;
 k=i+++j; //prints 7. i+++j is (i++)+j.
 printf("%d\n",k);

 int m=9;
 i=j=k=m;
 printf("i %d, j %d, k %d, m %d\n",i,j,k,m);

 float f = 2.0*'A'; printf("%f\n",f); // f cannot be printed as printf("char %c\n",f); since it's a float
 f = 12.0+'A'; printf("%f\n",f);
 c4 = 120; printf("%c\n",c4);

 // 3.3.2 assignment statement
 float f1,f2,f3;
 f1=f2=3.4;
 f1=(f2=4.4)+(f3=8.2);
 printf("f1 %f, f2 %f, f3 %f\n",f1,f2,f3);
 printf("f1 %f\n", f1=9.8);

 double d1=3.4532e20;
 printf("%20.7e\n",d1);
 printf("%-20.7e\n",d1);  // - means left-justified text, the default is right-justified.


}

