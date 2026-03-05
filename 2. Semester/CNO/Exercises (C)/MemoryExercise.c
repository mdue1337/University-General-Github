#include<stdio.h>
#include<stdlib.h>

int main(){
    int a[10];
    int *b = malloc(sizeof(int)*10);

    for (size_t i = 0; i < 10; i++)
    {
        a[i] = i*i;
    }
    
    for (size_t i = 0; i < 10; i++)
    {
        printf("index %d, value: %d, sizeof: %zu \n", i, a[i], sizeof(a[i]));
    }

    printf("%zu\n", sizeof(*b));        
    printf("%zu\n", 10 * sizeof(*b));
}