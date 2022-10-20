### FileSorter

This task has several tiers of complications

#### Default
1. File [unsorted.txt](unsorted.txt) contains `UTF-8` mixed letters and numbers. File length is up to 1000 symbols.
2. Write a program that reads this file and separates numbers and letters
3. Separated numbers and letters should be written into 2 files
   - `letters.txt` containing only letters from the original file (in the same order)
   - `numbers.txt` containing only numbers from the original file (in the same order)
4. Print total amount of letters and total amount of numbers

### Complications
#### Junior level
Write a program that generates a file of mixed `UTF-8` numbers and letters.

File length should be passed as an argument

#### Middle level
- Everything from **Junior level**
- Reading original file and writing output files should be done in separate threads

### Senior level
- Everything from **Middle level**
- Original file can be bigger than heap size