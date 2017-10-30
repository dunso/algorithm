# A Good Editor is a Best Start

![vscode](https://github.com/dunso/LeetCode/blob/master/Images/vscode.png)

I will strongly recommend [VSCode](https://code.visualstudio.com/) (Visual Studio Code) to write algorithm. It is a lightweight but powerful source code editor which runs on your desktop and is available for Windows, macOS and Linux. It comes with built-in support for JavaScript, TypeScript and Node.js and has a rich ecosystem of extensions for other languages (such as C, C++, C#, Java, Python, PHP, Go which are our main languages to write algorithm.) and runtimes (such as .NET and Unity).

**Now I will tell you how to install the software and configure it. You don't need to Install all I list below. You can just choose what you need.**

>1, Install VSCode <br/>
>2, Install C/C++<br/>
>3, Install GCC/G++<br/>
>4, Install Java<br/>
>5, Install Language Support for Java(TM) by Red Hat<br/>
>6, Install Java Language Support<br/>
>7, Install C#<br/>
>8, Install Code Runner<br/>
>9, Install LLVM<br/>
>10, Install Clang-Format<br/>
>11, Install Darcula IntelliJ Theme<br/>
------

# 1. Installation

## 1.1. Install VSCode
>All coders need to install this software

You can download from this site: [https://code.visualstudio.com/](https://code.visualstudio.com/).
And then install it just with several clicks.

## 1.2.  Install C/C++
>This is a Extension of VSCode. Coders use C or C++ need to install

(1) Open you VSCode<br/>
(2) Launch VS Code Quick Open (Ctrl+P), paste the following command, and press enter.

```
ext install cpptools
```
>Now you will know how to install it when you operater as I said above.

## 1.3. Install GCC/G++
>Coders use C or C++ need to install


(1) You can download from: [http://www.mingw.org/](http://www.mingw.org/) (the download button is on the top right）<br/>
(2) Before install it, please make sure you are connecting with the internet.<br/>
(3) Install the software you just downloaded.<br/>
(4) When you complete installation, there will be shown a management window.<br/>
(5) Find mingw32-gcc-g++ in the window, which Class attribute is `bin`.<br/>
(6) Right click `Mark for Installation`.<br/>
(7) Click `Apply Changes` under the menu `Installation` on the top left of the window.<br/>
(8) That' all, looks great!<br/>


> Now you need to add `C:\MinGW\bin` to your `Environment Variables` (Windows OS).<br/>
>Please Google if you don't know how to set `Environment Variables`.

Now you can check whether it has been installed successfully whih command line:
```
g++ -v
```
## 1.4. Install Java
>Coders use Java need to install

Please Google if you don't know how to install it

## 1.5. Language Support for Java(TM) by Red Hat
>Coders use Java need to install

The same way with C/C++ installing
```
ext install java
```
## 1.6. Install Java Language Support
>Coders use Java need to install

This Extension can show the errors in you code when you are typing.
```
ext install vscode-javac
```
## 1.7. Install CSharp
> Coders use C# need to install

```
ext install csharp
```

## 1.8. Install Code Runner
> All coders need to install

This Extension can help you Run and Debug code more easily.

```
ext install code-runner
```
## 1.9. Install LLVM
>All coders need to install

You can download form: [http://releases.llvm.org/download.html#4.0.1](http://releases.llvm.org/download.html#4.0.1). <br/>
Please download `Pre-Built Binaries` and then you can install it using the `.exe` file.

>Please Google if you don't know how to install it

## 1.10. Install Clang-Format
> All coders need to install

This Extension can help you format code more easily.

```
ext install clang-format
```

## 1.11. Install Darcula IntelliJ Theme
> No need to install if you like the default theme. Anyway, this theme is my best loveing
```
ext install dracula-theme-from-intellij
```
------
# 2. Configuration

**We have installed the software that we needed so far, Now we start to configure them**

>All the config will be write to the `setting.json`

Click `file` in the VSCode on top left. Then click `Preferences` --> `Settings`<br/>
Now please copy the code below to you setting.json
```
{
    "workbench.colorTheme": "Darcula Theme from IntelliJ",
    "java.home": "C:\\Program Files (x86)\\Java\\jdk1.8.0_112",
    "code-runner.executorMap": {
        "javascript": "node",
        "java": "cd $dir && javac $fileName -d ../Classes && java -classpath ../Classes $fileNameWithoutExt",
        "c": "cd $dir && gcc $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt",
        "cpp": "cd $dir && g++ $fileName -o ../exe/$fileNameWithoutExt && cd ../exe && $fileNameWithoutExt",
        "objective-c": "cd $dir && gcc -framework Cocoa $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt",
        "php": "php",
        "python": "python",
        "perl": "perl",
        "ruby": "ruby",
        "go": "go run",
        "lua": "lua",
        "groovy": "groovy",
        "powershell": "powershell -ExecutionPolicy ByPass -File",
        "bat": "cmd /c",
        "shellscript": "bash",
        "fsharp": "fsi",
        "csharp": "scriptcs",
        "vbscript": "cscript //Nologo",
        "typescript": "ts-node",
        "coffeescript": "coffee",
        "scala": "scala",
        "swift": "swift",
        "julia": "julia",
        "crystal": "crystal",
        "ocaml": "ocaml",
        "r": "Rscript",
        "applescript": "osascript",
        "clojure": "lein exec",
        "haxe": "haxe --cwd $dirWithoutTrailingSlash --run $fileNameWithoutExt",
        "rust": "cd $dir && rustc $fileName && $dir$fileNameWithoutExt",
        "racket": "racket",
        "ahk": "autohotkey",
        "autoit": "autoit3",
        "kotlin": "cd $dir && kotlinc $fileName -include-runtime -d $fileNameWithoutExt.jar && java -jar $fileNameWithoutExt.jar",
        "dart": "dart",
        "pascal": "cd $dir && fpc $fileName && $dir$fileNameWithoutExt",
        "d": "cd $dir && dmd $fileName && $dir$fileNameWithoutExt",
        "haskell": "runhaskell",
        "nim": "nim compile --verbosity:0 --hints:off --run"
    },
    "clang-format.executable": "C:\\Program Files\\LLVM\\bin\\clang-format",
    "clang-format.language.java.enable": true,
    "clang-format.language.java.style": "WebKit",
    "clang-format.language.c.enable": true,
    "clang-format.language.c.style": "WebKit",
    "clang-format.language.cpp.enable": true,
    "clang-format.language.cpp.style": "WebKit"
}
```

**Note:**
>1. `code-runner.executorMap` is the Code Runner configuration. I have configured the c, c++ and java. You can modify it accordingly
>2. `clang-format.executable` is the llvm bin path, please point it to the installation path 
>3. `clang-format.language.java.enable: true` means you will use clang-format to farmat java code.
>4. `clang-format.language.java.style: "WebKit` means format code to WebKit style, you can choose LLVM, Google, Chromium, Mozilla, WebKit or Json Style.

---
# 3.Usage

Coding and press `ctrl + alt + n` to build and run. That's all, great!

---
# LeetCode

------------

|Id  | Title  | Solution   | Time | Runtime |  Space | Difficulty  | Catagory|
| :------------: | :------------ | :------------: | :------------: | :------------: | :------------: | :------------: |:------------: |
|  <a href="https://leetcode.com/problems/two-sum" target="_blank">0001</a> |Two Sum | [C](https://e.srl/leetcode-1/)  |  no | 0ms  | O(n)  |  Easy |Array|
|  <a href="https://leetcode.com/problems/add-two-numbers" target="_blank">0002</a> |Add Two Numbers | [C](https://e.srl/leetcode-2/)  |  no |32ms  | O(1)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters" target="_blank">0003</a> |Longest Substring Without Repeating Characters | [C](https://e.srl/leetcode-3/)  |   no |18ms| O(n)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/median-of-two-sorted-arrays" target="_blank">0004</a> |Median of Two Sorted Arrays | [C](https://e.srl/leetcode-4/)  |   no |45ms| O(1)  |  Hard |Binary|
|  <a href="https://leetcode.com/problems/longest-palindromic-substring" target="_blank">0005</a> |Longest Palindromic Substring | [C](https://e.srl/leetcode-5/)  |   no |9ms| O(1)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/zigzag-conversion" target="_blank">0006</a> |ZigZag Conversion | [C#](https://e.srl/leetcode-6/)  |   no| | O(n)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/reverse-integer" target="_blank">0007</a> |Reverse Integer | [C](https://e.srl/leetcode-7/)  |   no |15ms| O(1)  |  Easy |Digital|
|  <a href="https://leetcode.com/problems/string-to-integer-atoi" target="_blank">0008</a> |String to Integer (atoi) | [C](https://e.srl/leetcode-8/)  |   no|15ms | O(1)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/palindrome-number" target="_blank">0009</a> |Palindrome Number | [C](https://e.srl/leetcode-9/)  |   no |185ms| O(1)  |  Easy |Digital|
|  <a href="https://leetcode.com/problems/regular-expression-matching" target="_blank">0010</a> |Regular Expression Matching | [C#](https://e.srl/leetcode-10/)  |   no| | O(m\*n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/container-with-most-water" target="_blank">0011</a> |Container With Most Water | [C](https://e.srl/leetcode-11/)  | O(n) |6ms| O(1)  |  Medium |Greedy|
|  <a href="https://leetcode.com/problems/integer-to-roman" target="_blank">0012</a> |Integer to Roman | [C,C++,C#](https://e.srl/leetcode-12/)  | O(n) |49ms| O(1)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/roman-to-integer" target="_blank">0013</a> |Roman to Integer | [C++](https://e.srl/leetcode-13/)  | O(n) |85ms| O(1)  |  Easy |Digital|
|  <a href="https://leetcode.com/problems/longest-common-prefix" target="_blank">0014</a> |Longest Common Prefix | [C](https://e.srl/leetcode-14/)  | O(n\*n) |3ms| O(n)  |  Easy |Array|
|  <a href="https://leetcode.com/problems/3sum" target="_blank">0015</a> |3Sum | [C](https://e.srl/leetcode-15/)  | O(n\*n) |97.96%| O(n\*n)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/3sum-closest" target="_blank">0016</a> |3Sum Closest | [C](https://e.srl/leetcode-16/)  | O(n\*n) |6ms| O(1)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number" target="_blank">0017</a> |Letter Combinations of a Phone Number | [C,C#](https://e.srl/leetcode-17/)  | O(n\*m) |0ms| O(n)  |  Medium |Queue|
|  <a href="https://leetcode.com/problems/4sum/" target="_blank">0018</a> |4Sum | [Java](https://e.srl/leetcode-18/)  | O(n\*n) |-| O(n\*n)  |  Medium |Math|
|  <a href="https://leetcode.com/problems/valid-parentheses/" target="_blank">0020</a> |Valid Parentheses | [Java]  | O(n) |-| O(n)  |  Easy |Stack|
|  <a href="https://leetcode.com/problems/merge-k-sorted-lists" target="_blank">0023</a> |Merge k Sorted Lists | [C,Java](https://e.srl/leetcode-23/)  | O(n\*logn) |9ms| O(n)  |  Hard |Heap|
|  <a href="https://leetcode.com/problems/reverse-nodes-in-k-group" target="_blank">0025</a> |Reverse Nodes in k-Group | [C,Java](https://e.srl/leetcode-25/)  | O(n) |6ms| O(1)  |  Hard |Linked|
|  <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/" target="_blank">0026</a> |Remove Duplicates from Sorted Array | [Java](https://e.srl/leetcode-26/)  | O(n) |12ms| O(1)  |  Easy |String|
|  <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words" target="_blank">0030</a> |Substring with Concatenation of All Words | [Java](https://e.srl/leetcode-30/)  | O(n) |23ms| O(n)  |  Hard |String|
|  <a href="https://leetcode.com/problems/longest-valid-parentheses" target="_blank">0032</a> |Longest Valid Parentheses | [C](https://e.srl/leetcode-32/)  | O(n) |6ms| O(n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/sudoku-solver" target="_blank">0037</a> |Sudoku Solver | [C](https://e.srl/leetcode-37/)  | O(n) |0ms| O(n\*n)  |  Hard |BT|
|  <a href="https://leetcode.com/problems/combination-sum" target="_blank">0039</a> |Combination Sum | [Java](https://e.srl/leetcode-39/)  | O(n\*n) |19ms| O(n\*n)  |  Medium |DFS|
|  <a href="https://leetcode.com/problems/combination-sum-ii/" target="_blank">0040</a> |Combination Sum II | [Java](https://e.srl/leetcode-40/)  | O(n\*n) |26ms| O(n\*n)  |  Medium |DFS|
|  <a href="https://leetcode.com/problems/first-missing-positive" target="_blank">0041</a> |First Missing Positive | [C](https://e.srl/leetcode-41/)  | O(n) |3ms| O(1)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/trapping-rain-water" target="_blank">0042</a> |Trapping Rain Water | [C](https://e.srl/leetcode-42/)  | O(n) |6ms| O(1)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/wildcard-matching/" target="_blank">0044</a> |Wildcard Matching | [C#](https://e.srl/leetcode-44/)  | O(n\*n) |162ms| O(n\*n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/jump-game-ii" target="_blank">0045</a> |Jump Game II | [C](https://e.srl/leetcode-45/)  | O(n) |6ms| O(1)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/rotate-image" target="_blank">0048</a> |Rotate Image | [Java](https://e.srl/leetcode-48/)  | O(n\*n) |2ms| O(1)  |  Medium |Matrix|
|  <a href="https://leetcode.com/problems/powx-n/" target="_blank">0050</a> |Pow(x, n) | [Java](https://e.srl/leetcode-50/)  | O(lgn) |99.47%| O(1)  |  Medium |Math|
|  <a href="https://leetcode.com/problems/n-queens" target="_blank">0051</a> |N-Queens | [C](https://e.srl/leetcode-51/)  | - |3ms| O(n\*n)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/maximum-subarray" target="_blank">0053</a> |Maximum Subarray | [Java](https://e.srl/leetcode-53/)  | O(n) |17ms| O(n)  |  Easy |DP|
|  <a href="https://leetcode.com/problems/spiral-matrix/" target="_blank">0054</a> |Spiral Matrix | [Java](https://e.srl/leetcode-54/)  | O(m\*n) |2ms| O(m\*n)  |  Medium |Matrix|
|  <a href="https://leetcode.com/problems/merge-intervals/" target="_blank">0056</a> |Merge Intervals | [Java]  | O(n) |-| O(n)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/insert-interval" target="_blank">0057</a> |Insert Interval | [C](https://e.srl/leetcode-57/)  | O(n) |6ms| O(n)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/set-matrix-zeroes/" target="_blank">0073</a> |Set Matrix Zeroes | [Java](https://e.srl/leetcode-73/)  | O(m\*n) |1ms| O(1)  |  Medium |Matrix|
|  <a href="https://leetcode.com/problems/search-a-2d-matrix" target="_blank">0074</a> |Search a 2D Matrix | [Java](https://e.srl/leetcode-74/)  | O(n) |1ms| O(1)  |  Medium |Sort|
|  <a href="https://leetcode.com/problems/sort-colors/" target="_blank">0075</a> |Sort Colors | [Java](https://e.srl/leetcode-75/)  | O(n) |0ms| O(1)  |  Medium |Array|
|  <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal" target="_blank">0105</a> |Construct Binary Tree from Preorder and Inorder Traversal | [Java](https://e.srl/leetcode-105/)  | O(n) |99.24%| O(n)  |  Medium |Tree|
|  <a href="https://leetcode.com/problems/word-ladder/" target="_blank">0127</a> |Word Ladder | [Java]  | O(n\*m\*k) |-| O(n)  |  Medium |BFS|
|  <a href="https://leetcode.com/problems/single-number" target="_blank">0136</a> |Single Number | [Java]  | O(n) |1MS| O(1)  |  Easy |BIT|
|  <a href="https://leetcode.com/problems/single-number-ii" target="_blank">0137</a> |Single Number II | [Java]  | O(32n) |9MS| O(1)  |  Medium |BIT|
|  <a href="https://leetcode.com/problems/word-break/" target="_blank">0139</a> |Word Break | [Java]  | O(n\*n) |-| O(n)  |  Medium |DP|
|  <a href="https://leetcode.com/problems/word-break-ii/" target="_blank">0140</a> |Word Break II | [Java]  | O(n\*n) |-| O(n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/sort-list/" target="_blank">0148</a> |Sort List | [Java](https://e.srl/leetcode-148/)  | O(nlgn) |99.91%| O(1)  |  Medium |Linked|
|  <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/" target="_blank">0150</a> |Evaluate Reverse Polish Notation | [Java]  | O(n) |-| O(n)  |  Medium |Stack|
|  <a href="https://leetcode.com/problems/maximum-product-subarray/" target="_blank">0152</a> |Maximum Product Subarray | [Java]  | O(n) |-| O(n)  |  Medium |DP|
|  <a href="https://leetcode.com/problems/excel-sheet-column-title" target="_blank">0168</a> |Excel Sheet Column Title | [Java]  | O(lgn) |2MS| O(n)  |  Easy |Math|
|  <a href="https://leetcode.com/problems/excel-sheet-column-number/" target="_blank">0171</a> |Excel Sheet Column Number | [Java]  | O(lgn) |0MS| O(n)  |  Easy |Math|
|  <a href="https://leetcode.com/problems/factorial-trailing-zeroes/" target="_blank">0172</a> |Factorial Trailing Zeroes | [Java]  | O(lgn) |1MS| O(1)  |  Easy |Math|
|  <a href="https://leetcode.com/problems/largest-number/" target="_blank">0179</a> |Largest Number | [Java](https://e.srl/leetcode-179/)  | O(n\*n) |99.89%| O(n)  |  Medium |Math| 
|  <a href="https://leetcode.com/problems/rotate-array" target="_blank">0189</a> |Rotate Array | [Java]  | O(n) |-| O(1)  |  Easy |Array| 
|  <a href="https://leetcode.com/problems/reverse-bits/" target="_blank">0190</a> |Reverse Bits | [Java]  | O(n) |3MS| O(1)  |  Easy |BIT| 
|  <a href="https://leetcode.com/problems/number-of-1-bits/" target="_blank">0191</a> |Number of 1 Bits | [Java]  | O(n) |1MS| O(1)  |  Easy |BIT| 
|  <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/" target="_blank">0201</a> |Bitwise AND of Numbers Range | [Java]  | O(n) |9MS| O(1)  |  Medium |BIT| 
|  <a href="https://leetcode.com/problems/happy-number/" target="_blank">0202</a> |Happy Number | [Java]  | - |5MS| O(1)  |  Easy |Math| 
|  <a href="https://leetcode.com/problems/count-primes/" target="_blank">0204</a> |Count Primes | [Java]  | - |22MS| O(n)  |  Easy |Math| 
|  <a href="https://leetcode.com/problems/reverse-linked-list" target="_blank">0206</a> |Reverse Linked List | [Java](https://e.srl/leetcode-206/)  | O(n) |0MS| O(1)  |  Easy |Linked|
|  <a href="https://leetcode.com/problems/implement-trie-prefix-tree" target="_blank">0208</a> |Implement Trie (Prefix Tree) | [C](https://e.srl/leetcode-208/)  | O(n) |39ms| O(n)  |  Medium |Tree|
|  <a href="https://leetcode.com/problems/kth-largest-element-in-an-array" target="_blank">0215</a> |Kth Largest Element in an Array | [Java]  | O(n\*lgn) |-| O(1)  |  Medium |Binary|
|  <a href="https://leetcode.com/problems/contains-duplicate" target="_blank">0217</a> |Contains Duplicate | [Java](https://e.srl/leetcode-217/)  | O(n) |99.39%| O(1)  |  Easy |Array|
|  <a href="https://leetcode.com/problems/invert-binary-tree/" target="_blank">0226</a> |Invert Binary Tree | [Java](https://e.srl/leetcode-226/)  | O(n) |0MS| O(1)  |  Easy |Tree|
|  <a href="https://leetcode.com/problems/power-of-two" target="_blank">0231</a> |Power of Two | [Java]  | O(1) |2MS| O(1)  |  Easy |BIT| 
|  <a href="https://leetcode.com/problems/search-a-2d-matrix-ii" target="_blank">0240</a> |Search a 2D Matrix II | [Java](https://e.srl/leetcode-240/)  | O(n + m) |13MS| O(1)  |  Medium |Matrix|
 <a href="https://leetcode.com/problems/perfect-squares" target="_blank">0279</a> |Perfect Squares | [Java](https://e.srl/leetcode-279/)  | O(n + m) |13MS| O(1)  |  Medium |Matrix|
|  <a href="https://leetcode.com/problems/longest-increasing-subsequence" target="_blank">0300</a> |Longest Increasing Subsequence | [Java](https://e.srl/leetcode-300/)  | O(n\*lgn) |0ms| O(n)  |  Medium |Binary Search DP| 
|  <a href="https://leetcode.com/problems/range-sum-query-mutable" target="_blank">0307</a> |Range Sum Query - Mutable | [Java](https://e.srl/leetcode-307/)  | O(n\*logn) |-| O(n)  |  Medium |Tree|
|  <a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self" target="_blank">0315</a> |Count of Smaller Numbers After Self | [C](https://e.srl/leetcode-315/)  | O(n\*logn) |16ms| O(n)  |  Hard |Tree|
|  <a href="https://leetcode.com/problems/remove-duplicate-letters" target="_blank">0316</a> |Remove Duplicate Letters | [C](https://e.srl/leetcode-316/)  | O(n) |3ms| O(n)  |  Hard |Greedy Stack|
|  <a href="https://leetcode.com/problems/create-maximum-number" target="_blank">0321</a> |Create Maximum Number | [C](https://e.srl/leetcode-321/)  | O(n\*k) |12ms| O(n)  |  Hard |Greedy Stack|
|  <a href="https://leetcode.com/problems/coin-change/" target="_blank">0322</a> |Coin Change | [C](https://e.srl/leetcode-322/)  | O(n\*k) |12ms| O(n)  |  Medium |DP|
|  <a href="https://leetcode.com/problems/count-of-range-sum" target="_blank">0327</a> |Count of Range Sum | [C](https://e.srl/leetcode-327/)  | O(n\*logn) |9ms| O(n)  |  Hard |Devide|
|  <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix" target="_blank">0329</a> |Longest Increasing Path in a Matrix | [Java](https://e.srl/leetcode-329/)  | O(n\*m) |16ms| O(n\*m)  |  Hard |DFS|
|  <a href="https://leetcode.com/problems/patching-array" target="_blank">0330</a> |Patching Array | [Java](https://e.srl/leetcode-330/)  | O(n) |1ms| O(1)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/self-crossing" target="_blank">0335</a> |Self Crossing | [Java](https://e.srl/leetcode-335/)  | O(n) |0ms| O(1)  |  Hard |Math|
|  <a href="https://leetcode.com/problems/palindrome-pairs" target="_blank">0336</a> |Palindrome Pairs | [Java](https://e.srl/leetcode-336/)  | O(n\*lgm) |52ms| O(n\*m)  |  Hard |Tree|
|  <a href="https://leetcode.com/problems/counting-bits/" target="_blank">0338</a> |Counting Bits | [Java](https://e.srl/leetcode-338/)  | O(n) |2ms| O(n)  |  Medium |Math|
|  <a href="https://leetcode.com/problems/integer-break/" target="_blank">0343</a> |Integer Break | [Java](https://e.srl/leetcode-343/)  | O(n\*n) |1ms| O(n)  |  Medium |DP|
|  <a href="https://leetcode.com/problems/data-stream-as-disjoint-intervals" target="_blank">0352</a> |Data Stream as Disjoint Intervals | [Java](https://e.srl/leetcode-352/)  | O(n\*lgn) |155ms| O(n)  |  Hard |Binary Search| 
|  <a href="https://leetcode.com/problems/russian-doll-envelopes" target="_blank">0354</a> |Russian Doll Envelopes | [Java](https://e.srl/leetcode-354/)  | O(n\*lgn) |13ms| O(n)  |  Hard |Binary Search DP| 
|  <a href="https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/" target="_blank">0363</a> |Max Sum of Rectangle No Larger Than K | [Java](https://e.srl/leetcode-363/)  | O(n^2\*lgn) |99.55%| O(n)  |  Hard |Devide| 
|  <a href="#" target="_blank">0370</a> |Range Addition  | [Java] | O(n) |-| O(n)  |   |   | 
|  <a href="https://leetcode.com/problems/combination-sum-iv/" target="_blank">0377</a> |Combination Sum IV | [Java](https://e.srl/leetcode-377/)  | O(n\*n) |6MS| O(n)  |  Medium |DP|
|  <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/" target="_blank">0380</a> |Insert Delete GetRandom O(1) | [Java](https://e.srl/leetcode-380/)  | O(1) |98.10%| O(n)  |  Medium |Array| 
|  <a href="https://leetcode.com/problems/4sum-ii/" target="_blank">0454</a> |4Sum II | [Java](https://e.srl/leetcode-454/)  | O(n\*n) |97.52%| O(n)  |  Medium |Math| 
|  <a href="https://leetcode.com/problems/array-partition-i" target="_blank">0561</a> |Array Partition I| [Java](https://e.srl/leetcode-561/)  | O(n) |90.95%| O(1)  |  Easy |Array| 
|  <a href="https://leetcode.com/problems/binary-tree-tilt" target="_blank">0563</a> |Binary Tree Tilt| [Java](https://e.srl/leetcode-563/)  | - |9MS| O(n)  |  Easy |Tree| 
|  <a href="https://leetcode.com/problems/array-nesting" target="_blank">0565</a> |Array Nesting| [Java](https://e.srl/leetcode-565/)  | O(n) |36MS| O(1)  |  Medium |Array| 
|  <a href="https://leetcode.com/problems/reshape-the-matrix" target="_blank">0566</a> |Reshape the Matrix| [Java](https://e.srl/leetcode-566/)  | O(n\*m) |7MS| O(n\*m)  |  Easy |Martix| 
|  <a href="https://leetcode.com/problems/permutation-in-string" target="_blank">0567</a> |Permutation in String| [Java](https://e.srl/leetcode-567/)  | O(n) |-| O(n)  |  Medium |String| 
|  <a href="https://leetcode.com/problems/subtree-of-another-tree" target="_blank">0572</a> |Subtree of Another Tree| [Java](https://e.srl/leetcode-572/)  | O(n) |13MS| O(1)  |  Easy |Tree| 
|  <a href="https://leetcode.com/problems/distribute-candies" target="_blank">0575</a> |Distribute Candies| [Java](https://e.srl/leetcode-575/)  | O(n) |95.78%| O(n)  |  Easy |Set| 
|  <a href="https://leetcode.com/problems/out-of-boundary-paths" target="_blank">0576</a> |Out of Boundary Paths| [Java](https://e.srl/leetcode-576/)  | - |95.73%| O(n\*m\*N)  |  Medium |DFS | 
|  <a href="https://leetcode.com/problems/delete-operation-for-two-strings" target="_blank">0583</a> |Delete Operation for Two Strings| [Java](https://e.srl/leetcode-58/)  | O(n\*m) |95.08%| O(n\*m)  |  Medium |DP | 
|  <a href="https://leetcode.com/problems/tag-validator" target="_blank">0591</a> |Tag Validator| [Java](https://e.srl/leetcode-591/)  | O(n) |19MS| O(n)  |  Hard |String| 
|  <a href="https://leetcode.com/problems/fraction-addition-and-subtraction/" target="_blank">0592</a> |Fraction Addition and Subtraction| [Java](https://e.srl/leetcode-592/)  | O(n) |16MS| O(n)  |  Medium |Math| 
|  <a href="https://leetcode.com/problems/valid-square" target="_blank">0593</a> |Valid Square| [Java](https://e.srl/leetcode-593/)  | O(n) |20MS| O(1)  |  Medium |Math| 
|  <a href="https://leetcode.com/problems/longest-harmonious-subsequence/" target="_blank">0594</a> |Longest Harmonious Subsequence| [Java](https://e.srl/leetcode-594/)  | O(n) |71MS| O(n)  |  Easy |Map| 
|  <a href="https://leetcode.com/problems/big-countries/" target="_blank">0595</a> |Big Countries| [MySql](https://e.srl/leetcode-595/)  | - |2979MS| -  |  Easy |Where| 
|  <a href="https://leetcode.com/problems/classes-more-than-5-students" target="_blank">0596</a> |Classes More Than 5 Students| [MySql](https://e.srl/leetcode-596/)  | - |2610MS| -  |  Easy |Group| 
|  <a href="#" target="_blank">0597</a> |Friend Requests I: Overall Acceptance Rate| Lock  | - |-| -  |  - |-| 
|  <a href="https://leetcode.com/problems/range-addition-ii" target="_blank">0598</a> |Range Addition II | [Java](https://e.srl/leetcode-598/)  | O(n) |6MS| O(1)  |  Easy |Matrix| 
|  <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists" target="_blank">0599</a> |Minimum Index Sum of Two Lists | [Java](https://e.srl/leetcode-599/)  | O(n) |26MS| O(n)  |  Easy |Map| 
|  <a href="https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/" target="_blank">0600</a> |Non-negative Integers without Consecutive Ones | [Java](https://e.srl/leetcode-600/)  | O(n) |-| O(n)  |  Hard |Math| 
|  <a href="https://leetcode.com/problems/image-smoother" target="_blank">0661</a> |Image Smoother | [Java](https://e.srl/leetcode-661/)  | O(m\*n) |27MS| O(m\*n)  |  Easy |Matrix| 
|  <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/" target="_blank">0673</a> |Number of Longest Increasing Subsequence | [Java](https://e.srl/leetcode-673/)  | O(m\*n) |27MS| O(m\*n)  |  Medium |DP| 




