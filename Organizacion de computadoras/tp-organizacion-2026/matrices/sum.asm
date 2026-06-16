; Export definition
section .text
    global add_matrices

; Addition subroutine
add_matrices:
    ; Prólogo
    push ebp
    mov ebp, esp

    ; Setup registers and fetch parameters
    xor eax, eax
    mov esi, [esp + 8]
    mov edi, [esp + 12]
    mov ax, [esp + 20]

    ; Multiply ax * ax
    mul ax

    ; Move the upper half of result and shift to match
    mov cx, dx
    shl ecx, 16
    ; Move lower half of the result
    mov cx, ax

    ; Reset eax to 0 to use as accumulator
    xor eax, eax

    ; Fetch result matrix address (3rd parameter)
    mov edx, [esp + 16]

    ; Matrix sum subroutine
    .sum:
        ; Add correspondig values in eax
        add eax, [esi]
        add eax, [edi]
        ; Move the sum into the result matrix position
        mov [edx], eax
        ; Increment pointer register to next address
        add esi, 4
        add edi, 4
        add edx, 4
        ; Reset eax value to 0 for next sum
        xor eax, eax
    loop .sum

    ; Epílogo
    pop ebp
    ret
