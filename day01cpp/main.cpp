#include <iostream>
#include <fstream>
#include <cstring>

#define LINE_MAX 1000

int sumAns1(int *numArray1, int *numArray2) {
    int sum = 0;
    int temp;

    for (int i = 0; i < LINE_MAX; i++) {
        std::cout << numArray1[i] << " - " << numArray2[i] << "\n";

        temp = numArray1[i] - numArray2[i];

        if (temp<0) temp *= -1;

        sum += temp;
    }

    return sum;
}

int sumAns2(int *numArray1, int *numArray2) {
    int sum = 0;
    int temp;

    for (int i = 0; i < LINE_MAX; i++) {
        temp = 0;

        for (int a = 0; a < LINE_MAX; a++) {
            if (numArray1[i] == numArray2[a]) {
                temp++;
            }

            if (numArray1[i] > numArray2[a]) {
                continue;
            }
        }

        sum += temp * numArray1[i];
    }

    return sum;
}

int main() {
    std::ifstream file ("/home/kubax/AdventOfCode2024/day01cpp/input.txt");
    std::string line;

    int numArray1[LINE_MAX];
    int numArray2[LINE_MAX];

    if ( file.is_open() ) {
        for ( int lineCount = 0; lineCount < LINE_MAX; lineCount++ ) {
            std::getline (file, line);

            char lineArray[14];
            strncpy(lineArray, line.c_str(), sizeof(lineArray));

            char tempCharArray1[6] = {lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]};
            char tempCharArray2[6] = {lineArray[8], lineArray[9], lineArray[10], lineArray[11], lineArray[12]};
//            char tempCharArray1[6] = {lineArray[0]};
//            char tempCharArray2[6] = {lineArray[4]};

            int num1 = std::stoi(std::string(tempCharArray1));
            int num2 = std::stoi(std::string(tempCharArray2));

            std::cout << num1 << " <-> " << num2 << "\n";

            numArray1[lineCount] = num1;
            numArray2[lineCount] = num2;
        }
    }

    int temp;

    std::cout << "\n";

    // Meh Sort
    for(int i = 0; i < LINE_MAX; i++) {
        for(int a = 0; a < LINE_MAX; a++) {
            if (numArray1[a] > numArray1[i]) {
                temp = numArray1[a];
                numArray1[a] = numArray1[i];
                numArray1[i] = temp;
            }

            if (numArray2[a] > numArray2[i]) {
                temp = numArray2[a];
                numArray2[a] = numArray2[i];
                numArray2[i] = temp;
            }
        }
    }

    std::cout << "\n Answer 1: " << sumAns1(numArray1, numArray2) << "\n";
    std::cout << "Answer 2: " << sumAns2(numArray1, numArray2);

    return 0;
}
