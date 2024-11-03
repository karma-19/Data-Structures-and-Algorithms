# -*- coding: utf-8 -*-
"""
Created on Mon Jun 29 12:40:47 2020

@author: LG
"""
fibonacci_cache = {}

def fib(n):
    if n in fibonacci_cache:
        return fibonacci_cache[n]
    
    if n==0:
        value = 0
    if n==1:
        value = 1
    if n==2:
        value = 1
    if n>2:
        value = (fib(n-1) + fib(n-2))
        
    fibonacci_cache[n]=value
    return value


n = int(input())
print(fib(n))
print(fibonacci_cache, end='\n')

