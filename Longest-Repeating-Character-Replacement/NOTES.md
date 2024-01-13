-> count the frequency of each char in the input string
-> there are 26 upper case english characters
-> probably choose the highest frequency char to use as the replacement char. and by that we mean that we replace the least occuring character.
   in a particular window.
-> brute force approach would be to check every single substring.
-> windowLen - count[most_freq_char] = (n) and (n) here means the # of replacements needed to be made. this value must be less than or equal to (k).
-> 