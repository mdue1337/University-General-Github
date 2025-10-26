using System.Text;

namespace LeetCode75
{
    public class ArrayAndStrings
    {
        static void Main(string[] args)
        {
            Console.WriteLine(GcdOfStrings("ABABAB", "ABAB"));
        }

        public static string MergeAlternately(string word1, string word2)
        {
            StringBuilder word = new StringBuilder();
            List<string> charsOne = word1.Select(c => c.ToString()).ToList();
            List<string> charsTwo = word2.Select(c => c.ToString()).ToList();

            int pointerOne = 0;
            int pointerTwo = 0;

            while (pointerOne < charsOne.Count && pointerTwo < charsTwo.Count)
            {
                word.Append(charsOne[pointerOne]);
                pointerOne++;

                word.Append(charsTwo[pointerTwo]);
                pointerTwo++;
            }

            while (pointerOne < charsOne.Count)
            {
                word.Append(charsOne[pointerOne]);
                pointerOne++;
            }

            while (pointerTwo < charsTwo.Count)
            {
                word.Append(charsTwo[pointerTwo]);
                pointerTwo++;
            }

            return word.ToString();
        }

        public static string GcdOfStrings(string str1, string str2)
        {
            // find the largest substring that exists in both" is close, but it’s more specifically “find the largest substring that, when repeated, fully builds both strings
            string longestSubstring = "";

            for (int i = 0; i < str1.Length; i++)
            {
                for (int j = 0; j < str2.Length; j++)
                {
                    // Build substrings starting at i or j
                    string sub1 = str1.Substring(0, i + 1);
                    string sub2 = str2.Substring(0, j + 1);

                    // Compare substrings
                    if (sub1.Equals(sub2))
                    {
                        // Check if they can be the common divider for both strings
                        if(Divides(str1, sub1) && Divides(str2, sub1))
                        {
                            longestSubstring = sub1;
                        }
                    }
                }
            }

            return longestSubstring;

            bool Divides(string full, string part)
            {
                // If full's length is not a multiple of part's length, then part cannot possibly repeat to build full
                if (full.Length % part.Length != 0)
                    return false;

                // Build a new string by repeating 'part'
                string built = "";

                // Number of times 'part' must repeat to match 'full'
                int times = full.Length / part.Length;

                // Repeat 'part' that many times
                for (int i = 0; i < times; i++)
                {
                    built += part;
                }

                // Check if the repeated string matches the original
                return built == full;
            }
        }
    }
}
