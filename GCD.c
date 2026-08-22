#include <stdio.h>

int main() {
    int number1, number2, original1, original2, remainder;

    scanf("%d %d", &number1, &number2);

    original1 = number1;
    original2 = number2;

    while (number2 != 0) {
        remainder = number1 % number2;
        number1 = number2;
        number2 = remainder;
    }

    printf("The GCD of %d and %d is %d", original1, original2, number1);

    return 0;
}