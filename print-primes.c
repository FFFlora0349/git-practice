#include <stdio.h>
#include "check-prime.h"

#define true 1
#define false 0

int check_prime(int a)
{
 int divisor=2;
 if (a==2) 
 {
  #ifdef PRINT 
  printf("is prime\n");
  #endif
  return true;
 }
 while (divisor < a)
 {
  if (a%divisor == 0) 
  {
   #ifdef PRINT
   printf("not prime\n"); 
   #endif
   return false;
  }
  divisor++;
 }
 #ifdef PRINT
 printf("is prime\n");
 #endif
 return true;
}

int main()
{
 for (int i=2;i<=1000;i++)
 {
  if (check_prime(i)==true) printf("%d ", i);
 } 
}


