#include<stdio.h>
#include<stdlib.h>

int main(){
    short* s = malloc(sizeof(short) * 10); // s points to 10 shorts (2 bytes each)
    int* t = s;                            // t points to the same memory, but as ints (4 bytes), thus this will create UB

    for (size_t i = 0; i < 10; i++)
    {
        s[i] = i + 1;
    }
    
    for (size_t i = 0; i < 10; i++)
    {
        printf("s-array; index: %d, value: %d \n", i, s[i]);
    }

    for (size_t i = 0; i < 5; i++)
    {
        printf("t-array; index: %d, value: %X \n", i, t[i]);
    }
}