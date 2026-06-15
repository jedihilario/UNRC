# Compilers
CC = gcc
ASM = nasm

# Compilers flags
CFLAGS = -m32 -Wall
ASMFLAGS = -f elf32

TARGET = amor

all: $(TARGET)

$(TARGET): n.o tomito.o
	$(CC) $(CFLAGS) $^ -o $@

n.o: n.c
	$(CC) $(CFLAGS) -c $< -o $@

tomito.o: tomito.asm
	$(ASM) $(ASMFLAGS) $< -o $@

mdo:
	rm -f *.o $(TARGET)

.PHONY: all clean
