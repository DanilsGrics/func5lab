class Lab5 {

    class Isogram {
        companion object {
            fun isIsogram(suggestedString: String): Boolean =

                    suggestedString
                            .toLowerCase()
                            .replace("-", "")
                            .replace(" ", "")
                            .toSet() //excludes duplicates
                            .size.compareTo(suggestedString
                                    .toLowerCase()
                                    .replace("-", "")
                                    .replace(" ", "")
                                    .toCharArray() //doesn't exclude duplicates
                                    .size) //comparing sizes of collection and array which allows duplicates
                            .toString()
                            .replace("0", "true")
                            .toBoolean()
        }
    }

    class IsbnVerifier {

        fun isValid(suggestedISBN: String): Boolean =

                suggestedISBN
                        .toLowerCase()
                        .replace("-", "")
                        .matches(Regex(pattern = "^\\d{9}[\\d|x]$"))
                        .compareTo(true).toString()
                        .replace("0", suggestedISBN
                                .toLowerCase()
                                .replace("-", ""))
                        .dropLast(1)
                        .foldIndexed(suggestedISBN
                                .toLowerCase()
                                .replace("-", "")
                                .matches(Regex(pattern = "^\\d{10}$"))
                                .compareTo(true).toString()
                                .replace("0", (suggestedISBN
                                        .toLowerCase()
                                        .replace("-", "")
                                        .drop(9)))
                                .replace("-1", "10")
                                .toInt())
                        { i, acc, c -> acc + (c - '0') * (10 - i) }.rem(11) == 0


    }

    class WordCount {
        companion object {
            fun phrase(phraseToInspect: String): Map<String, Int> =

                    phraseToInspect
                            .toLowerCase()
                            .replace("\n", " ").replace(" '", " ")
                            .replace("' ", " ").replace(",", " ")
                            .replace("  ", " ")
                            .replace(Regex(pattern = "[^0-9a-z' ]"), "")
                            .split(" ")
                            .groupingBy { it }
                            .eachCount()
        }

    }
}