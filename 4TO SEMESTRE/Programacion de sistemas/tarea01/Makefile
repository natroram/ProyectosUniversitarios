CC=gcc
CFLAGS=-I.

programa: main.o distanceFunc.o
		$(CC) -o programa main.o distanceFunc.o

main.o: main.c 
		$(CC) $(CFLAGS) main.c 

distanceFunc.o: distanceFunc.c 
		$(CC) $(CFLAGS) distanceFunc.c 

.PHONY: clean
clean:
		rm *.o programa 