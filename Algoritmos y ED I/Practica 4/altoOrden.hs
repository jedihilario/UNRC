-- Funciones de alto orden

-- 15) Dada una lista de enteros, retornar la lista de sus cuadrados
sq :: Int -> Int
sq n = n * n

squareList :: [Int] -> [Int]
squareList [] = []
squareList xs = map sq xs

-- 19) Dada una lista de naturales, devolver una lista con sus sucesores
succesorList :: [Int] -> [Int]
succesorList [] = []
succesorList xs = map (+ 1) xs

-- 20) Dada una lista de enteros, sumar todos sus elementos
sumList :: [Int] -> Int
sumList xs = foldl (+) 0 xs

-- 21) Definir el factorial usando fold
factorial :: Int -> Int
factorial n = foldl (*) 1 [1..n]
