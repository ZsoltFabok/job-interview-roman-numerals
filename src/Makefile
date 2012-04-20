CC=g++

CFLAGS=-c -Wall

all: romannum

romannum: main.o romannum.o
	$(CC) main.o romannum.o -o romannum

main.o: main.cpp
	$(CC) $(CFLAGS) main.cpp

romannum.o: romannum.cpp
	$(CC) $(CFLAGS) romannum.cpp
	
test: test_roman.o
	$(CC) test_roman.o -o test_roman
	./test_roman

test_roman.o:
	$(CC) $(CFLAGS) romannum.cpp -D__TEST__ -o test_roman.o

clean:
	rm -f *.o romannum test_roman
