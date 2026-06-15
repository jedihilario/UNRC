#include <stdio.h>

// External definiton of add_matrices function
extern int add_matrices (int* m, int* n, int* res, short s);

int main (void) {
    int a[3][3] = { { 10, 60, 7 }, { 3, 4, 6 }, { 2, 2, 2 } };
    int b[3][3] = { { 1, 7, 5 }, { 3, 4, 8 }, { 1, 1, 1 } };
    int res[3][3];
    short s = 3;

    add_matrices(&a[0][0], &b[0][0], &res[0][0], s);

    for (int i = 0; i < s; i++) {
        printf("[ ");
        for (int j = 0; j < s; j++) {
            printf(" %d ", res[i][j]);
        }
        printf(" ]\n");
    }

    return 0;
}
