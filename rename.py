#!/usr/bin/env python
# coding=utf-8
import os

path = '/Users/zhouchao/source/leetcode-solutions'

files = os.listdir(path)

for i in files:
    old = path + '/' + i
    new = path + '/' + "0" + i
    os.rename(old, new)
