-- Listas por comprensión

-- 24) Dada una lista de enteros, retornar sus sucesores
succesorList :: [Int] -> [Int]
succesorList xs = [x + 1 | x <- xs]

-- 25) Dada una lista de naturales, retornar sus cuadrados
sqList :: [Int] -> [Int]
sqList ns = [n * n | n <- ns]

-- 26) Dada una lista de enteros, retornar los elementos pares mayores a 10
evenGreaterThanTen :: [Int] -> [Int]
evenGreaterThanTen xs = [x | x <- xs, even x, x > 10]

-- 27) Dado un entero, retornar sus divisores
divs :: Int -> [Int]
divs n = [x | x <- [(- abs n) .. (abs n)], n `mod` x == 0]

-- 30) Definir la lista infinita de los números pares
evens :: [Int]
evens = [2 * n | n <- [1..]]

-- 31) Dadas dos listas de naturales, retornar su producto cartesiano
cartesianProd :: [Int] -> [Int] -> [(Int, Int)]
cartesianProd xs ys = [(x, y) | x <- xs, y <- ys]

-- 32) Usando listas por comprensión determinar qué número n 1<=n<=5000 cumple k-1|n, para 1<=k<=10

condition :: Int -> Int -> Bool
condition n 1 = True
condition n k = n `mod` k == k-1 && condition n (k-1)

findNumber :: [Int]
findNumber = [x | x <- [1..5000], condition x 10]

main = print findNumber
