535. Encode and Decode TinyURL
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.


public class Codec {
    //思路分析：tinyurl 格式：http://tinyurl.com/ + 6位随机码，使用哈希表， 
    //加密的时候生成随机tinyurl,若tinyurl 不存在则以tinyurl key， val 是原url
    
    
    HashMap<String,String> map = new HashMap<>();
    String TINYURL_PREFIX = "http://tinyurl.com/";
    String INDEX = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String newShort = "";
        while(true){
            for(int i=0; i< 6; ++i){
                newShort += INDEX.charAt((int) (Math.random() % 62));
            }
            String resStr = TINYURL_PREFIX + newShort;
            if(!map.containsKey(resStr)){
                map.put(resStr,longUrl);
            }
            return resStr;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));




//选择一个存储结构SQL 还是NoSQL 
//需要支持事务吗？ NoSQL 不支持事务 --> 不需要 NoSQL
//需要支持rich SQL query 吗？ --> 不需要NoSQL
//需要高效开发吗？ 大多数的网络框架对于SQL的支持性能非常好，意味着系统不需要设计太多代码 --> 无所谓，代码量很少
//需要AUTO_ICREMENT ID 吗？ No SQL 不支持这个， 只有全局的唯一object_id; -->算法需要AUTO_INCREMENT_ID
//需要高QPS吗？ NoSQL 具有高性能。 比如Memcached的QPS可达百万级别，MondoDB可达万级别，MySQL 只有千级 -->写200，读2k，不高,SQL
//系统的可伸缩性能有多高，SQL需要开发写代码去伸缩Scale， 而NoSQL自带该功能 --> 不高