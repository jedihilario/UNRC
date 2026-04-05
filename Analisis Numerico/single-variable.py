import numpy as np
from collections.abc import Callable

# Implementación del método de bisección
def bisection (f: Callable[[float], float], a: float, b: float, eps: float, max_steps: int) -> float:

    # Lanzar un error si el intervalo dado no es válido
    if (f(a) * f(b) > 0): raise ValueError("El intervalo dado no es válido")

    # Iterar, a lo sumo, tantas veces como indique { max_stepts }
    for i in range(max_steps):
        # Crear e inicializar p con un valor no válido
        p: float = np.inf

        # Usar media geométrica, si es posible
        if (a > 0 and b > 0 and b > 2 * a):
            p = np.sqrt(a * b)
        else:
            p = float((a + b) / 2)

        # Si se encontró la raíz, o la aproximación es suficientemente buena, retornar p_i
        if (f(p) == 0 or (b - a) / 2 < eps):
            return p

        # Reasignar el borde según corresponda
        if (f(a) * f(p) < 0):
            b = p
        else:
            a = p

    raise Exception(f'No se logró una aproximación lo suficientemente buena en {max_steps} pasos.')

f = lambda x: x - np.pi

print(np.pi)
print(bisection(f, 1, 1e200, 1e-10, 1001))