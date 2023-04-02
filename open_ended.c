#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
    int id = fork();
    if (id != 0)
    {
        fork();
    }
}