/*
 * main.cpp
 *
 *  Created on: Apr 19, 2012
 *      Author: albert
 */
#include <cstdlib>
#include <iostream>
#include <iomanip>
#include "romannum.h"

using namespace std;

int main()
{
	unsigned short int number = 0;
	while( cin >> number )
	{
		cout << setw(6) << setfill(' ') << number << "-> " << romannum(number) << endl;
	}
	return EXIT_SUCCESS;
}
