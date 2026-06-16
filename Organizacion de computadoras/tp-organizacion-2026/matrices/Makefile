# Compilers
CC = gcc
ASM = nasm

# Compilers flags
CFLAGS = -m32 -Wall
ASMFLAGS = -f elf32

TARGET = executable

all: $(TARGET)

$(TARGET): main.o sum.o
	$(CC) $(CFLAGS) $^ -o $@

main.o: main.c
	$(CC) $(CFLAGS) -c $< -o $@

sum.o: sum.asm
	$(ASM) $(ASMFLAGS) $< -o $@

clean:
	rm -f *.o $(TARGET)

.PHONY: all clean
