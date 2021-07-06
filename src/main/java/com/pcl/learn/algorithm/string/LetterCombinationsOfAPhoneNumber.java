/*
 * Copyright 2021 Chenglin Peng.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pcl.learn.algorithm.string;

import java.util.*;

/**
 * @description:
 * @author: pengchenglin
 * @create: 2021-06-23 23:22
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        System.out.println(list.toString());
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        if(digits.length()==1){
            return map.get(digits.charAt(0));
        }
        if(digits.length()==2){
            List<String> slist = new ArrayList<>();
            for(String s:map.get(digits.charAt(0))){
                for(String s1:map.get(digits.charAt(1))){
                    slist.add(s+s1);
                }
            }
            return slist;
        }
        if(digits.length()==3){
            List<String> slist = new ArrayList<>();
            for(String s:map.get(digits.charAt(0))){
                for(String s1:map.get(digits.charAt(1))){
                    for(String s2:map.get(digits.charAt(2))){
                        slist.add(s+s1+s2);
                    }
                }
            }
            return slist;
        }

        if(digits.length()==4){
            List<String> slist = new ArrayList<>();
            for(String s:map.get(digits.charAt(0))){
                for(String s1:map.get(digits.charAt(1))){
                    for(String s2:map.get(digits.charAt(2))){
                        for(String s3:map.get(digits.charAt(3))){
                            slist.add(s+s1+s2+s3);
                        }
                    }
                }
            }
            return slist;
        }
        return new ArrayList<>();

    }
    public Map<Character,List<String>> map = new HashMap<Character,List<String>>(){
        {
            put('2', Arrays.asList("a","b","c"));
            put('3', Arrays.asList("d","e","f"));
            put('4', Arrays.asList("g","h","i"));
            put('5', Arrays.asList("j","k","l"));
            put('6', Arrays.asList("m","n","o"));
            put('7', Arrays.asList("p","q","r","s"));
            put('8', Arrays.asList("t","u","v"));
            put('9', Arrays.asList("w","x","y","z"));
        }
    };
}
