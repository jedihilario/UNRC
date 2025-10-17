-- Listas

-- 1) Definir:
-- hd :: [a] -> a, retorna el primer elemento de una lista
{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use product" #-}
{-# HLINT ignore "Eta reduce" #-}
{-# HLINT ignore "Use sum" #-}
hd :: [a] -> a
hd (x:xs) = x

-- tl :: [a] -> [a], retorna la lista sin el primer elemento
tl :: [a] -> [a]
tl [] = []
tl (x:xs) = xs

-- last' :: [a] -> a, retorna el último elemento de la lista
last' :: [a] -> a
last' [x] = x
last' (x:xs) = last xs

-- init' :: [a] -> [a], retorna la lista sin el último elemento
init' :: [a] -> [a]
init' [] = []
init' [x] = []
init' (x:xs) = x : init' xs

-- 2) Definir  una función que devuelva el reverso de una lista
reverso :: [a] -> [a]
reverso [] = []
reverso (x:xs) = reverso xs ++ [x]

-- 3) Definir una función que decida si dos listas son iguales
equalList :: Eq a => [a] -> [a] -> Bool
equalList [] [] = True
equalList (x:xs) [] = False
equalList [] (y:ys) = False
equalList (x:xs) (y:ys) = x == y && equalList xs ys

-- 4) Definir una función que decida si una lista el palíndroma
isPalindrome :: Eq a => [a] -> Bool
isPalindrome [x] = True
isPalindrome (x:xs) = x == last' xs && isPalindrome (init xs)
