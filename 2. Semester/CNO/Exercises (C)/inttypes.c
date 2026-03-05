#include <stdio.h>

int main(void){
    char c = 1;
    short s = 1;
    int i = 1;
    long l = 1;
    long long ll = 1;

    printf("Size of a char type is %zu byte or %zu bits. \n", sizeof(c), sizeof(c)*8);
    printf("Size of a short type is %zu byte or %zu bits. \n", sizeof(s), sizeof(s)*8);
    printf("Size of a int type is %zu byte or %zu bits. \n", sizeof(i), sizeof(i)*8);
    printf("Size of a long type is %zu byte or %zu bits. \n", sizeof(l), sizeof(l)*8);
    printf("Size of a long long type is %zu byte or %zu bits. \n\n", sizeof(ll), sizeof(ll)*8);

    char* cp = &c;
    short* sp = &s;
    int* ip = &i;
    long* lp = &l;
    long long* llp = &ll;

    printf("Size of a char* type is %zu byte or %zu bits, has address %p \n", sizeof(cp), sizeof(cp)*8, cp);
    printf("Size of a s* type is %zu byte or %zu bits, has address %p \n", sizeof(sp), sizeof(sp)*8, sp);
    printf("Size of a i* type is %zu byte or %zu bits, has address %p \n", sizeof(ip), sizeof(ip)*8, ip);
    printf("Size of a long* type is %zu byte or %zu bits, has address %p \n", sizeof(lp), sizeof(lp)*8, lp);
    printf("Size of a long long* type is %zu byte or %zu bits, has address %p \n", sizeof(llp), sizeof(llp)*8, llp);

    (*ip)++;
    printf("i incremented by using the pointer *ip to: %d \n", i);
}