#include<stdio.h>
#include<stdlib.h>

typedef struct ll_item ll_item; 
typedef int ll_int;

// Define an element of the linked list. 
struct ll_item { 
    ll_item *prev; 
    ll_item *next; 
    ll_int value; 
};

int main()
{
    ll_item item1;
    ll_item item2;

    item1.value = 10;
    item2.value = 20;

    item1.next = &item2;
    item2.prev= &item1;

    for (size_t i = 0; i < 1; i++)
    {
        printf("Previous: %p, Next: %p, Value: %d", item1.prev, item1.next, item1.value);
    }
}
