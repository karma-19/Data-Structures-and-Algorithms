# -*- coding: utf-8 -*-
"""
Created on Tue Jun 30 12:12:31 2020

@author: LG
"""

fibo_cache = {}
#from functools import lru_cache
#@lru_cache(maxsize=1000)
def fibo(n):
    if n in fibo_cache:
        return fibo_cache[n]
    
    if n == 0:
        value = 0
    if n == 1:
        value = 1
    if n==2:
        value = 1
    if n>2:
        value = (fibo(n-1) + fibo(n-2))
        
    fibo_cache[n] = value
    
    return value

for n in range(60000):
    print(n ,': ', fibo(n))