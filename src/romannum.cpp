/*
 * romannum.cpp
 *
 *  Created on: Apr 19, 2012
 *      Author: albert
 */

#include "romannum.h"
#include <climits>
#define UPPER_LIMIT 20000


using namespace std;

const char* 			 Roman_Letters[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
const unsigned short int Roman_Values[]  = {  1,   4,    5,   9,	10,  40,  50,   90,  100, 400,  500,  900,  1000 };
const unsigned short	 Num_Values = sizeof(Roman_Values) / sizeof(unsigned short int);

string romannum(unsigned short int num)
{
	if( num > UPPER_LIMIT )
		return "";
	string roman = "";
	for( int i = Num_Values-1; i>=0; i-- )
		while ( num >= Roman_Values[i] )
		{
			roman += Roman_Letters[i];
			num -= Roman_Values[i];
		}
	return roman;
}

#ifdef __TEST__
#define CATCH_CONFIG_MAIN
#include "catch.hpp"

TEST_CASE( "romannum", "function should return correct roman numeral" )
{
	REQUIRE( romannum(0) == "" );
	REQUIRE( romannum(1) == "I" );
	REQUIRE( romannum(1954) == "MCMLIV" );
	REQUIRE( romannum(1990) == "MCMXC" );
	REQUIRE( romannum(600) == "DC" );
	REQUIRE( romannum(88) == "LXXXVIII" );
	REQUIRE( romannum(89) == "LXXXIX" );
	REQUIRE( romannum(UPPER_LIMIT+1) == "" );
	REQUIRE( romannum(UPPER_LIMIT) != "" );
}
#endif
