# SimplePasswordGenerator
A short Java program that generates memorable passwords.

I coded this in ~20 minutes because I wanted an easy, customizable way to generate passwords offline.

# Security
There are 126,328 words in the dictionary.
This means the entropy of one word chosen uniformly at random is approximately 16 bits.

[Nist Guidelines](https://pages.nist.gov/800-63-3/sp800-63b.html) suggest that passwords be generated with >112 bits of entropy.
Therefore strong generated passwords should consist of at least 112/16 = 7 words minimum.
