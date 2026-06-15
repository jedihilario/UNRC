section .text
    global add_matrices

add_matrices:
    xor eax, eax
    mov esi, [esp + 4]
    mov edi, [esp + 8]
    mov ax, [esp + 16]
    mul ax
    mov ecx, eax
    xor eax, eax

    mov edx, [esp + 12]

    .sum:
        add eax, [esi]
        add eax, [edi]
        mov [edx], eax
        add esi, 4
        add edi, 4
        add edx, 4
        xor eax, eax

    loop .sum

    ret
