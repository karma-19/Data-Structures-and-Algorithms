# -*- coding: utf-8 -*-
"""
Created on Tue Sep  8 20:06:13 2020

@author: Praveen
"""
import random
import time
#starttime = time.time()

def norm_exponention(a, n):
    starttime = time.time()
    ans = a**n
    endtime = time.time()
    return ans, endtime-starttime
    
def bin_exponention(a, n):
    
    
    if n ==0:
        return 1
    elif n==1:
        return a
    else:
        res = bin_exponention(a, n//2)
        if n%2:
            return res*res*a
        else:
            return res*res
    
    
def bin_iter(a, b):
    starttime = time.time()
    res = 1
    while(b>0):
        if(b & 1):
            res = res*a
        a = a*a
        b >>= 1
    endtime = time.time()
    return res, endtime-starttime

#a, n = map(int, input('enter a to the power n: ').split())

a = 10
n = 57000
"""
while True:
    a = random.randint(10, 100)
    n = random.randint(10, 110000)
    res2 = bin_iter(a, n)
    print('binary --> ', res2)
    res1 = norm_exponention(a, n)
    print('normal --> ', res1)
    if res1 == res2:
        print(" OK " )
    else:
        print("-------wrong answer-------")
        break
"""
print('BINARY -> a : ', a, 'n : ', n, bin_iter(a,n))
print('NORMAL -> a : ', a, 'n : ', n, norm_exponention(a,n))




