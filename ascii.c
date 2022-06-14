#include <stdio.h>

int main(int argc, char* argv[]){
 printf("\x57\150\x61\164\x20\144\x6f\40\x77\145\x20\144\x6f\x20\141\x66\164\x65\162\x20\163\x74\141\x72\142\x75\143\x6b\163\x3f\40\x57\145\x20\147\x6f\40\x74\157\40\x73\145\x70\150\x6f\162\x61\40\x61\156\x64\40\x73\151\x6d\157\x6e\163\x20\146\x6f\162\x20\163\x68\157\x70\160\x69\156\x67\56\n"); // \nnn is for oct, \xnnn is for hex.
 signed char c = 119; // char = nnn with %c in printf is for dec.
 signed char d = 113;
 unsigned char e = 65;
 char f = 74;
 printf("c %c, d %c, e %c, f %c\n", c,d,e,f); 
 printf("c %d, d %d, e %d, f %d\n", c,d,e,f);
 const double p = 3.1415L;
 int a = -5/3; // truncated, -1.6667 -> -1
 printf("p %f, %d", p, a); 
   
}

