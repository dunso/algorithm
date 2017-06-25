using System;
using System.Diagnostics;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Csharp.DP
{
    [TestClass]
    public class LeetCode0044
    {
        public bool IsMatch(string s, string p)
        {
            bool[,] dp = new bool[s.Length + 1, p.Length + 1];

            int[] pos = new int[p.Length + 1];

            pos[0] = p.Length > 0 && p[0] == '*' ? 1 : 0;

            dp[0, 0] = true;

            for (var j = 0; j < p.Length && p[j] == '*'; j++)
            {
                dp[0, j + 1] = true;
            }
            
            for (var i = 1; i <= s.Length; i++)
            {
                for (var j = 1; j <= p.Length; j++)
                {
                    if (p[j - 1] == '*' && pos[j - 1] > 0)
                    {
                            dp[i, j] = true;
                            pos[j] = i;
                    }
                    else
                    {
                        dp[i, j] = (s[i - 1] == p[j - 1] || p[j - 1] == '?') && dp[i - 1, j - 1];
                        pos[j] = dp[i, j] ? i : pos[j];
                    }
                }
            }
            return dp[s.Length, p.Length];
        }

        [TestMethod]
        public void Test()
        {
            Trace.WriteLine(IsMatch("zacabz", "*a?b*"));
        }
    }
}
