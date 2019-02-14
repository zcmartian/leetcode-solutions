#!/bin/bash
tags="algorithms array hash-table linked-list math two-pointers string binary-search divide-and-conquer dynamic backtracking stack heap greedy sort bit-manipulation tree depth-first breadth-first union-find graph design topological-sort trie binary-indexed-tree segment-tree queue reservoir-sampling map"

echo "|tag|easy(total-done-todo)|medium|hard|total|"
echo "|:---:|:---:|:---:|:---:|:---:|"
a=`leetcode list -q L | wc -l`
ad=`leetcode list -q dL | wc -l`
aD=`leetcode list -q DL | wc -l`
ae=`leetcode list -q eL | wc -l`
aed=`leetcode list -q edL | wc -l`
aeD=`leetcode list -q eDL | wc -l`
am=`leetcode list -q mL | wc -l`
amd=`leetcode list -q mdL | wc -l`
amD=`leetcode list -q mDL | wc -l`
ah=`leetcode list -q hL | wc -l`
ahd=`leetcode list -q hdL | wc -l`
ahD=`leetcode list -q hDL | wc -l`
echo "|TOTAL|${ae}-${aed}-${aeD}|${am}-${amd}-${amD}|${ah}-${ahd}-${ahD}|${a}-${ad}-${aD}|"
for tag in ${tags}; do
    t=`leetcode list -q L -t ${tag} | wc -l`
    td=`leetcode list -q dL -t ${tag} | wc -l`
    tD=`leetcode list -q DL -t ${tag} | wc -l`
    et=`leetcode list -q eL -t ${tag} | wc -l`
    ed=`leetcode list -q edL -t ${tag} | wc -l`
    eD=`leetcode list -q eDL -t ${tag} | wc -l`
    mt=`leetcode list -q mL -t ${tag} | wc -l`
    md=`leetcode list -q mdL -t ${tag} | wc -l`
    mD=`leetcode list -q mDL -t ${tag} | wc -l`
    ht=`leetcode list -q hL -t ${tag} | wc -l`
    hd=`leetcode list -q hdL -t ${tag} | wc -l`
    hD=`leetcode list -q hDL -t ${tag} | wc -l`
    echo "|${tag}|${et}-${ed}-${eD}|${mt}-${md}-${mD}|${ht}-${hd}-${hD}|${t}-${td}-${tD}|"
done
