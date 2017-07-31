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
---

# LeetCode

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
|  <a href="https://leetcode.com/problems/3sum" target="_blank">0015</a> |3Sum | [C](https://e.srl/leetcode-15/)  | O(n\*n) |76ms| O(n\*n)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/3sum-closest" target="_blank">0016</a> |3Sum Closest | [C](https://e.srl/leetcode-16/)  | O(n\*n) |6ms| O(1)  |  Medium |Digital|
|  <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number" target="_blank">0017</a> |Letter Combinations of a Phone Number | [C,C#](https://e.srl/leetcode-17/)  | O(n\*m) |0ms| O(n)  |  Medium |Queue|
|  <a href="https://leetcode.com/problems/merge-k-sorted-lists" target="_blank">0023</a> |Merge k Sorted Lists | [C,Java](https://e.srl/leetcode-23/)  | O(n\*logn) |9ms| O(n)  |  Hard |Heap|
|  <a href="https://leetcode.com/problems/reverse-nodes-in-k-group" target="_blank">0025</a> |Reverse Nodes in k-Group | [C,Java](https://e.srl/leetcode-25/)  | O(n) |6ms| O(1)  |  Hard |Linked|
|  <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words" target="_blank">0030</a> |Substring with Concatenation of All Words | [Java](https://e.srl/leetcode-30/)  | O(n) |23ms| O(n)  |  Hard |String|
|  <a href="https://leetcode.com/problems/longest-valid-parentheses" target="_blank">0032</a> |Longest Valid Parentheses | [C](https://e.srl/leetcode-32/)  | O(n) |6ms| O(n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/sudoku-solver" target="_blank">0037</a> |Sudoku Solver | [C](https://e.srl/leetcode-37/)  | O(n) |0ms| O(n\*n)  |  Hard |BT|
|  <a href="https://leetcode.com/problems/first-missing-positive" target="_blank">0041</a> |First Missing Positive | [C](https://e.srl/leetcode-41/)  | O(n) |3ms| O(1)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/trapping-rain-water" target="_blank">0042</a> |Trapping Rain Water | [C](https://e.srl/leetcode-42/)  | O(n) |6ms| O(1)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/wildcard-matching/" target="_blank">0044</a> |Wildcard Matching | [C#](https://e.srl/leetcode-44/)  | O(n\*n) |162ms| O(n\*n)  |  Hard |DP|
|  <a href="https://leetcode.com/problems/jump-game-ii" target="_blank">0045</a> |Jump Game II | [C](https://e.srl/leetcode-45/)  | O(n) |6ms| O(1)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/n-queens" target="_blank">0051</a> |N-Queens | [C](https://e.srl/leetcode-51/)  | - |3ms| O(n\*n)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/insert-interval" target="_blank">0057</a> |Insert Interval | [C](https://e.srl/leetcode-57/)  | O(n) |6ms| O(n)  |  Hard |Array|
|  <a href="https://leetcode.com/problems/implement-trie-prefix-tree" target="_blank">0208</a> |Implement Trie (Prefix Tree) | [C](https://e.srl/leetcode-208/)  | O(n) |39ms| O(n)  |  Medium |Tree|
|  <a href="https://leetcode.com/problems/contains-duplicate" target="_blank">0217</a> |Contains Duplicate | [Java](https://e.srl/leetcode-217/)  | O(n) |99.39%| O(1)  |  Easy |Array|
|  <a href="https://leetcode.com/problems/longest-increasing-subsequence" target="_blank">0300</a> |Longest Increasing Subsequence | [Java](https://e.srl/leetcode-300/)  | O(n\*lgn) |0ms| O(n)  |  Medium |Binary Search DP| 
|  <a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self" target="_blank">0315</a> |Count of Smaller Numbers After Self | [C](https://e.srl/leetcode-315/)  | O(n\*logn) |16ms| O(n)  |  Hard |Tree|
|  <a href="https://leetcode.com/problems/remove-duplicate-letters" target="_blank">0316</a> |Remove Duplicate Letters | [C](https://e.srl/leetcode-316/)  | O(n) |3ms| O(n)  |  Hard |Greedy Stack|
|  <a href="https://leetcode.com/problems/create-maximum-number" target="_blank">0321</a> |Create Maximum Number | [C](https://e.srl/leetcode-321/)  | O(n\*k) |12ms| O(n)  |  Hard |Greedy Stack|
|  <a href="https://leetcode.com/problems/count-of-range-sum" target="_blank">0327</a> |Count of Range Sum | [C](https://e.srl/leetcode-327/)  | O(n\*logn) |9ms| O(n)  |  Hard |Devide|
|  <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix" target="_blank">0329</a> |Longest Increasing Path in a Matrix | [Java](https://e.srl/leetcode-329/)  | O(n\*m) |16ms| O(n\*m)  |  Hard |DFS|
|  <a href="https://leetcode.com/problems/patching-array" target="_blank">0330</a> |Patching Array | [Java](https://e.srl/leetcode-330/)  | O(n) |1ms| O(1)  |  Hard |Greey|
|  <a href="https://leetcode.com/problems/self-crossing" target="_blank">0335</a> |Self Crossing | [Java](https://e.srl/leetcode-335/)  | O(n) |0ms| O(1)  |  Hard |Math|
|  <a href="https://leetcode.com/problems/palindrome-pairs" target="_blank">0336</a> |Palindrome Pairs | [Java](https://e.srl/leetcode-336/)  | O(n\*lgm) |52ms| O(n\*m)  |  Hard |Tree|
|  <a href="https://leetcode.com/problems/data-stream-as-disjoint-intervals" target="_blank">0352</a> |Data Stream as Disjoint Intervals | [Java](https://e.srl/leetcode-352/)  | O(n\*lgn) |155ms| O(n)  |  Hard |Binary Search| 
