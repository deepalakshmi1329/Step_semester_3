#include <stdio.h>

int main() {
    int number, origNumber, reversedNumber = 0, digit;

    scanf("%d", &number);

    origNumber = number;

    while (number != 0) {
        digit = number % 10;
        reversedNumber = reversedNumber * 10 + digit;
        number = number / 10;
    }

    printf("Is the number %d a Palindrome? %s", origNumber,
           reversedNumber == origNumber ? "Yes" : "No");

    return 0;
}