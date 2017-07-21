Hash Function

In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:

hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).

Given a string as a key and the size of hash table, return the hash value of this key.f


Example
For key="abcd" and size=100, return 78


关于哈希表：

哈希表在内存中是一个事先开辟好的数组，通过hash function把一个key转化为某一个index，来实现O(1)的查找
理想状态下，每次算出的index都是唯一的，而实际上会有Collision
hash function设计标准是越乱越没有规则越好，以避免Collision，一般是通过某种方式将key转化为一个integer然后对hash table size取模
哈希表的size最好要是所要存的数字数量的10倍，当size不够时，需要rehashing。
如何处理冲突 - Collision

Open hashing - 冲突的话，index下面采用linked list
Closed hashing - 如果有冲突，则向前或者向后位移。致命缺点，不支持删除，所以几乎没人采用
将key转化为整数的方式有：

MD5, 但是耗费较大
APR hash function - magic number 33(只是经验值)
