# -*- coding: utf-8 -*-
"""
Created on Wed Jul 29 21:56:53 2020

@author: LG
"""

def period(m):
    prev, curr = 0,1
    for i in range(m*m):
        prev, curr \
        = curr, (prev+curr)%m
        
        if prev==0 and curr==1:
            return i+1
        
def fib_modulo(n,m):
    period_ans = period(m)
    n = n%period_ans
    prev , curr = 0, 1
    if n == 0:
        return 0
    if n == 1:
        return 1
    for i in range(n-1):
        prev, curr = curr, prev+curr
        
    return curr%m
    

n, m= map(int, input().split())
print(fib_modulo(n,m))