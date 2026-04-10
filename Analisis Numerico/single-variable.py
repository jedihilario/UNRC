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

# Implementación del método de punto fijo
def fixed_point (g: Callable[[float], float], init: float, eps: float, max_steps: int) -> float:
    # Inicializar la variable de iteración enésima y de error, en valores fuera de rango
    p: float = np.inf
    err: float = np.inf

    # Iterar hasta una cantidad de { max_steps } inclusive
    for i in range(max_steps):
        # Guardar el valor de la iteración y error actuales
        p = g(init)
        err = np.abs(p - init)

        # Verificar si el error obtenido cumple con las condiciones dadas. En dicho caso, retornar el valor obtenido
        if (err < eps):
            return p

        # Almacenar el valor de iteracion actual para la próxima iteración
        init = p

    # Lanzar una excepción si no se logra la aproximación deseada
    raise Exception(f'No se logró una aproximación lo suficientemente buena en {max_steps} pasos.')

def newton (init: float, f: Callable[[float], float], df: Callable[[float], float], eps: float, max_steps: int) -> float:
    p: float = np.inf

    for i in range(max_steps):
        assert df(init) != 0

        p = init - f(init)/df(init)
        error = np.abs(p - init)

        if (error < eps):
            return p

        init = p

    # Lanzar una excepción si no se logra la aproximación deseada
    raise Exception(f'No se logró una aproximación lo suficientemente buena en {max_steps} pasos.')

f = lambda x: np.cbrt(x + 1)

print(fixed_point(f, 1, 1e-5, 100))
