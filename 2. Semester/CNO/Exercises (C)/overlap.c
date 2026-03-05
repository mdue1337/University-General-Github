#include<stdio.h>
#include<stdlib.h>

int main(){
    int *a, *b;
    a = (int*) malloc(sizeof(int) * 100); // 400 bytes
    b = a + 50; // add 200 bytes (50*4=200), thus we are at a[50]

    for (size_t i = 0; i < 100; i++)
    {
        a[i] = i + 1;
    }

    for (size_t i = 0; i < 5; i++)
    {
        printf("value: %d \n", b[i]);
    }

    free(a);

    return 0;
}