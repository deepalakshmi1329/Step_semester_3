#include <stdio.h>

int main() {
    int number, origNumber, sum = 0, digit;

    scanf("%d", &number);

    origNumber = number;

    while (number != 0) {
        digit = number % 10;
        sum = sum + digit * digit * digit;
        number = number / 10;
    }

    printf("Is the number %d an Armstrong number? %s", origNumber,
           sum == origNumber ? "Yes" : "No");

    return 0;
}