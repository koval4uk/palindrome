package palindrom.services;

import java.util.*;
import java.util.stream.Stream;

public class PalindromProcessor {
    private List<String> source;
    private Map<Integer, List<String>> palindromes;
    private boolean parallel;
    private String separator = "[ .,]";

    PalindromProcessor() {
    }

    public PalindromProcessor(List<String> source){
        this.palindromes = new HashMap<>();
        this.source = source;
    }

    PalindromProcessor(String source){
        this.palindromes = new HashMap<>();
        this.source = Collections.singletonList(source);
    }

    public Map<Integer, List<String>> processFile(){
        Stream<String> content = parallel?source.parallelStream():source.stream();
        content.forEach(line -> {
            List<String> tokens = Arrays.asList(line.split(separator));
            Stream<String> tokensStream = parallel?tokens.parallelStream():tokens.stream();
            tokensStream.forEach(token ->{
                if(isPalindrome(token)){
                    List<String> list = palindromes.getOrDefault(token.length(), new LinkedList<>());
                    list.add(token);
                    palindromes.put(token.length(), list);
                }
            });
        });
        return palindromes;
    }

    boolean isPalindrome(String word){
        if(word == null || word.length()<=2) return false;
        for(int i=0; i<word.length()/2; i++){
            if(word.charAt(i)!=word.charAt(word.length()-i-1)) return false;
        }
        return true;
    }

    public List<String> getLongestPalindromes(){
        if(palindromes.size()==0) return null;
        Optional<Integer> maxLength = palindromes.keySet().stream().max(Integer::compareTo);
        return palindromes.get(maxLength.orElse(0));
    }


    public boolean isParallel(){
        return parallel;
    }

    public void setParallel(boolean parallel) {
        this.parallel = parallel;
    }
}
