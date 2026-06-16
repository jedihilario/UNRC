# Compilers
CC = gcc
ASM = nasm

# Compilers flags
CFLAGS = -m32 -Wall
ASMFLAGS = -f elf32

# Final target (executable)
TARGET = executable

# Global task
all: $(TARGET)

# Global dependencies
$(TARGET): main.o sum.o
	$(CC) $(CFLAGS) $^ -o $@

# C dependencies
main.o: main.c
	$(CC) $(CFLAGS) -c $< -o $@

# NASM dependecies
sum.o: sum.asm
	$(ASM) $(ASMFLAGS) $< -o $@

# Clean task
clean:
	rm -f *.o $(TARGET)

.PHONY: all clean
