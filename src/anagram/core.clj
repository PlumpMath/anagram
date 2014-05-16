(ns anagram.core
  (:require [clojure.string :as str]
            [clojure.data :as data]))

;; take each word from the wordlist
;; See if each word can be formed from the letters in the target

(def wordfile "/Users/zand/dev/clojure/anagram/src/anagram/wordlist.txt")

(defn process-dictionary
  "Reads the dictionary file and returns a vector of strings"
  [filename]
  (->
    (slurp filename)
    str/split-lines
    vec))

(def word-vec
  "produces a vector of strings from a dictionary file"
  (process-dictionary wordfile))

(def smdict
  "takes a small subset of the dict vec for testing"
  (vec (repeatedly 2000 #(rand-nth word-vec))))

(defn contains-chars?
  "Predicate to decide if the letters of one string1 are containted in string2 another"
  [string1 string2]
  (let [s1 (frequencies string1)
        s2 (frequencies string2)
        diffs (data/diff s1 s2 )]
    (print s1 "\n")
    (print s2 "\n")
    (print diffs)
    (= s1 (last diffs))))

(defn foo
  "given a tuple, finds that tuple in a map"
  [t m]
  (let [tkey (first t)
        tval (last t)
        mkey (get m tkey)
        mval (last mkey)]
    (println tkey)
    (println tval)
    (println mkey)
    (println mval)
    (<= tval mval)))

(def tup [\f 1])
(def m {\f 1, \h 2, \r 3})