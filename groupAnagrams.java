/** 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */
class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> output = new HashMap<>();

        for (String word : strs) {
            helper(word,output);

        }
        System.out.println(output.toString());
        return new ArrayList<>(output.values());

    }

    public static void helper(String word, Map<String, List<String>> map) {
        int[] alphabetForCurrentWord = new int[26];
        for (char letter : word.toCharArray()) {
            alphabetForCurrentWord[letter - 'a'] = alphabetForCurrentWord[letter - 'a'] + 1;
        }
        StringBuilder key = new StringBuilder();
        for (Integer num : alphabetForCurrentWord) {
            key.append(num.toString());
        }
        String stringKey = key.toString();

        System.out.println(key);

        if (map.containsKey(stringKey) ) {
            // get its value (list) and add my current word to list and put it again to map

            List<String> tempList = map.get(stringKey);
            tempList.add(word);

            map.put(stringKey,tempList);
        }
        else {
            List<String> temp = new ArrayList<>();
            temp.add(word);
            map.put(stringKey,temp);
        }


    }
}
