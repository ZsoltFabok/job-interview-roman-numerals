/*
 * test_roman.cpp
 *
 *  Created on: Apr 20, 2012
 *      Author: albert
 *
 *      Test cases for romannum conversion function
 */

#include "romannum.h"

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
