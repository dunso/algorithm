using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Diagnostics;

namespace Csharp.DP
{
    [TestClass]
    public class LeetCode0010
    {
        public bool IsMatch(string s, string p)
        {
            bool[,] dp = new bool[s.Length + 1, p.Length + 1];

            dp[0, 0] = true;

            for (var j = 0; j < p.Length - 1 && dp[0, j]; j += 2)
            {
                dp[0, j + 2] = p[j + 1] == '*';
            }

            for (var i = 1; i <= s.Length; i++)
            {
                for (var j = 1; j <= p.Length; j++)
                {
                    if (p[j - 1] == '*')
                    {
                        dp[i, j] = (p[j - 2] == '.' || p[j - 2] == s[i - 1]) && dp[i - 1, j] || dp[i, j - 2];
                    }
                    else
                    {
                        dp[i, j] = (p[j - 1] == '.' || p[j - 1] == s[i - 1]) && dp[i - 1, j - 1];
                    }
                }
            }
            return dp[s.Length, p.Length];
        }

        [TestMethod]
        public void Test()
        {
            Trace.WriteLine(IsMatch("aab", "c*a*b"));
        }
    }
}
